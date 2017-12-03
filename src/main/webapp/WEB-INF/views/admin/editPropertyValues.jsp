<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/admin/adminHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类管理</title>
<style type="text/css">
.main {
	width: 1080px;
	margin: 0 auto;
	margin-bottom:200px;
}

div.catalog {
	text-align: left;
}

table {
	width: 100%;
}

table tr td, th {
	text-align: center;
	font-size: 16px;
}

img.categoryImg {
	width: 100px;
	height: 20px;
}

div.add-Title {
	line-height: 30px;
	background-color: #C0C0C0;
	margin-bottom: 10px;
}

.addCategory {
	width: 450px;
	margin: 0 auto;
	border: 1px solid #cccccc;
	border-radius: 4px;
}

.reminder {
	background-color: #2FB255;
	text-align: center;
	display: none;
	position:fixed;
	width: 100%;
	line-height: 30px;
	z-index: 99;
}
</style>
<script type="text/javascript">
	$(function() {

		$('input.editValue').blur(function() {
			var value = $(this).val();
			var pvid = $(this).attr('pvid');

			$.post("propertyValue/update", {
				"value" : value,
				"id" : pvid
			}, function(result) {
				if ("success" == result) {
					$(".reminder").fadeIn();
					var t = setTimeout("$('.reminder').fadeOut()", 1500);
				} else {
					$(".reminder").css("background-color", "#BD2D30");
					$(".reminder").fadeIn();
					var t = setTimeout("$('.reminder').fadeOut()", 1500);
				}
			})

		});

	});
</script>
</head>
<body>
	<div class='reminder'>
		<span>修改成功</span>
	</div>
	<div class='main'>
		<%@include file="/WEB-INF/views/include/admin/adminNavigator.jsp"%>
		<div class='catalog'>
			<ul class="breadcrumb">
				<li>
					<a href="category/list">分类管理</a>
				</li>
				<li>
					<a href="product/list?cid=${product.category.id}">${product.category.name}</a>
				</li>
				<li class="active">${product.name}</li>
				<li class="active">产品属性编辑</li>
			</ul>
		</div>
		<div class='categorydiv'>
			<c:forEach items="${requestScope.propertyValues}" var="item" varStatus="status">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">${item.property.name}:</span>
					<input type="text" class="form-control editValue" name='${item.property.name}' value='${item.value}' pvid="${item.id}" aria-describedby="basic-addon1">
				</div>
			</c:forEach>
		</div>
		<%@include file="/WEB-INF/views/include/admin/adminFooter.jsp"%>
	</div>
</body>
</html>