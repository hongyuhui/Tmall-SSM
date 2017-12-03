$(function(){
	
	$('.addReviewButton').on("click",function(){
		//评论内容空标记
		var Empty = true;
		//遍历每一个商品评价块
		$('.reviewContent').each(function(){
			Empty = checkEmpty($(this).attr('id'), "评价内容");
			if(!Empty){
				return false;
			}
			var pid = $(this).attr('pid');
			var content = $('.reviewContent[pid='+pid+']').val();
			$.get("front/addReview",{"pid":pid,"content":content},function(result){
				if("success"==result){
					var num = $('.reviewStasticsNumber[pid='+pid+']').text();
					num = Number(num);
					$('.reviewStasticsNumber[pid='+pid+']').text(num+1);
					$('.makeReviewDiv[pid='+pid+']').hide();
					$('.reviewSuccess[pid='+pid+']').show();
				}
			});
		});
		if(!Empty){
			return false;
		}
		//全都评价完后改变订单状态
		var oid = $(this).attr("oid");
		$.get("front/reviewDone",{"oid":oid},function(result){
			if("success"==result){
				location.href='front/myOrder';
			}
		});
		
	})
	
	
	
	
})
