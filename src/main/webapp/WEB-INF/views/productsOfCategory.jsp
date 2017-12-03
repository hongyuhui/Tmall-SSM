<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file='/WEB-INF/views/include/admin/adminHeader.jsp'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类产品</title>
<link rel="stylesheet" href='css/productsOfCategory.css'>
<script type="text/javascript">
	$(function() {
		$('.sortBarPrice').keyup(function() {
			/* 			var num = $(this).val();
			 if (num.length == 0) {
			 $('.productUnit').show();
			 return;
			 } */
			var beginPrice = $('.beginPrice').val();
			var endPrice = $('.endPrice').val();
			/* 使用null判断无效，因为输入的至少是个空字符串 */
			if (beginPrice.length == 0 || isNaN(beginPrice) || beginPrice < 0) {
				//错误设为0
				beginPrice = 0;
			}
			if (endPrice.length == 0 || isNaN(endPrice) || endPrice < beginPrice) {
				endPrice = 999999999999;
			}
			var s = "${param.sort}";
			$('.productUnit').hide();
			$('.productUnit').each(function() {
				var price = $(this).attr('price');
				price = Number(price);
				if (beginPrice <= price && price <= endPrice) {
					$(this).show();
				}
			})
		});
	});
</script>
</head>
<body>
	<%@ include file='/WEB-INF/views/include/FrontTop.jsp'%>
	<%@ include file='/WEB-INF/views/include/search.jsp'%>
	<div class="categoryPageDiv">
		<img src="img/category/${category.id }.jpg">
		<div class="categorySortBar">
			<table class="categorySortBarTable categorySortTable">
				<tbody>
					<tr>
						<td
							<c:if test="${'all'==param.sort||empty param.sort}">class="grayColumn"</c:if>>
							<a href="front/category?sort=all&id=${category.id }"> 综合 <span
								class=""></span>
						</a>
						</td>
						<td
							<c:if test="${'reviewCount'==param.sort}">class="grayColumn"</c:if>>
							<a href="front/category?sort=reviewCount&id=${category.id }">
								人气 <span class=" glyphicon glyphicon-sort"></span>
						</a>
						</td>
						<td <c:if test="${'date'==param.sort}">class="grayColumn"</c:if>>
							<a href="front/category?sort=date&id=${category.id }"> 新品 <span
								class="glyphicon glyphicon-sort"></span>
						</a>
						</td>
						<td
							<c:if test="${'saleCount'==param.sort}">class="grayColumn"</c:if>>
							<a href="front/category?sort=saleCount&id=${category.id }">
								销量 <span class="glyphicon glyphicon-sort"></span>
						</a>
						</td>
						<td <c:if test="${'price'==param.sort}">class="grayColumn"</c:if>>
							<a href="front/category?sort=price&id=${category.id }"> 价格 <span
								class="glyphicon glyphicon-sort"></span>
						</a>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="categorySortBarTable">
				<tbody>
					<tr>
						<td><input type="text" name='beginPrice' placeholder="起始价格"
							class="sortBarPrice beginPrice"></td>
						<td class="grayColumn priceMiddleColumn">-</td>
						<td><input type="text" name='endPrice' placeholder="最高价格"
							class="sortBarPrice endPrice"></td>
					</tr>
				</tbody>
			</table>
			<div style='clear: both;'></div>
		</div>
		<div class="categoryProducts">
			<c:forEach items='${category.products }' var='product'>
				<div price="${product.promoteprice }" class="productUnit">
					<div class="productUnitFrame">
						<a href="front/product?id=${product.id }"> <img width="100px"
							src="img/productSingle/${product.firstProductImage.id }.jpg"
							class="productImage">
						</a> <span class="productPrice">¥${product.promoteprice }</span> <a
							href="front/product?id=${product.id }" class="productLink">
							${product.name } </a> <a href="front/home" class="tmallLink">天猫专卖</a>
						<div class="show1 productInfo">
							<span class="monthDeal "> 月成交 <span
								class="productDealNumber">${product.saleCount }笔</span>
							</span> <span class="productReview"> 评价 <span
								class="productReviewNumber">${product.reviewCount }</span>
							</span> <span class="wangwang"> <a class="wangwanglink"> <img
									src="img/site/wangwang.png">
							</a>
							</span>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<%@include file='/WEB-INF/views/include/loginModal.jsp'%>
	</div>
	<%@include file='/WEB-INF/views/include/bottom.jsp'%>
</body>
</html>