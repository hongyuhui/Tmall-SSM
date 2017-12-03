<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file='/WEB-INF/views/include/admin/adminHeader.jsp'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
<link rel='stylesheet' href='css/shoppingCart.css'>
<script type="text/javascript" src='js/shoppingCart.js'></script>
</head>
<body>
	<%@ include file='/WEB-INF/views/include/FrontTop.jsp'%>
	<%@ include file='/WEB-INF/views/include/search.jsp'%>
	<div class='page'>
		<div class="cartDiv">
			<div class="cartTitle pull-right">
				<span>已选商品 (不含运费)</span>
				<span class="cartTitlePrice">￥0.00</span>
				<form action="front/buyNow" method="post">
					<input class='oiids' name='oiids' value='' type="hidden">
					<button class="createOrderButton" style="background-color: rgb(170, 170, 170);" disabled="disabled">结 算</button>
				</form>
			</div>
			<div style='clear: both;'></div>
			<div class="cartProductList">
				<table class="cartProductTable">
					<thead>
						<tr>
							<th class="selectAndImage">
								<img src="img/site/cartNotSelected.png" class="selectAllItem" selectit="false">
								全选
							</th>
							<th>商品信息</th>
							<th>单价</th>
							<th>数量</th>
							<th width="120px">金额</th>
							<th class="operation">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items='${orderitems }' var='oi'>
							<tr class="cartProductItemTR" oiid="${oi.id }">
								<td>
									<img src="img/site/cartNotSelected.png" class="cartProductItemIfSelected" oiid="${oi.id }" selectit="false">
									<a href="#nowhere" style="display: none">
										<img src="img/site/cartSelected.png">
									</a>
									<img width="40px" src="img/productSingle/${oi.product.firstProductImage.id }.jpg" class="cartProductImg">
								</td>
								<td class='cartProductLink'>
									<div class="cartProductLinkOutDiv">
										<a class="cartProductLink" href="front/product?id=${oi.product.id }">${oi.product.name }</a>
										<div class="cartProductLinkInnerDiv">
											<img title="支持信用卡支付" src="img/site/creditcard.png">
											<img title="消费者保障服务,承诺7天退货" src="img/site/7day.png">
											<img title="消费者保障服务,承诺如实描述" src="img/site/promise.png">
										</div>
									</div>
								</td>
								<td>
									<span class="cartProductItemOringalPrice">
										￥
										<fmt:formatNumber minFractionDigits="2" type='number' value='${oi.product.originalprice }'></fmt:formatNumber>
									</span>
									<span class="cartProductItemPromotionPrice">
										￥
										<fmt:formatNumber minFractionDigits="2" type='number' value=' ${oi.product.promoteprice }'></fmt:formatNumber>
									</span>
								</td>
								<td>
									<div class="cartProductChangeNumberDiv">
										<span pid="${oi.product.id }" class="hidden orderItemStock ">${oi.product.stock }</span>
										<span pid="${oi.product.id }" class="hidden orderItemPromotePrice "> ${oi.product.promoteprice }' </span>
										<button class="numberMinus" oiid="${oi.id }" pid="${oi.product.id }">-</button>
										<input value="${oi.number }" autocomplete="off" class="orderItemNumberSetting" oiid="${oi.id }" pid="${oi.product.id }">
										<button class="numberPlus" oiid="${oi.id }" pid="${oi.product.id }" stock="${oi.product.stock }">+</button>
									</div>
								</td>
								<td>
									<span pid="${oi.product.id }" oiid="${oi.id }" class="cartProductItemSmallSumPrice">
										￥
										<fmt:formatNumber minFractionDigits="2" type='number' value='${oi.number*oi.product.promoteprice}'></fmt:formatNumber>
									</span>
								</td>
								<td>
									<a href="front/deleteOrderItem" oiid="${oi.id }" class="deleteOrderItem">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="cartFoot">
				<img src="img/site/cartNotSelected.png" class="selectAllItem" selectit="false">
				<span>全选</span>
				<!--         <a href="#">删除</a> -->
				<div class=" cartFoot-right pull-right">
					<span>
						已选商品
						<span class="cartSumNumber">0</span>
						件
					</span>
					<span>合计 (不含运费): </span>
					<span class="cartSumPrice">￥0.00</span>
					<div class="createOrderButtonDiv">
						<form action="front/buyNow" method="post">
							<input class='oiids' name='oiids' value='' type="hidden">
							<button class="createOrderButton" type="submit" style='height: 40px;' disabled="disabled">结 算</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<%@include file='/WEB-INF/views/include/loginModal.jsp'%>
	</div>
	<%@include file='/WEB-INF/views/include/bottom.jsp'%>
</body>
</html>