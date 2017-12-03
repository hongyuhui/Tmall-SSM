<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file='/WEB-INF/views/include/admin/adminHeader.jsp'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认收货</title>
<link rel='stylesheet' href='css/reciveConfirm.css'>
</head>
<body>
	<%@ include file='/WEB-INF/views/include/FrontTop.jsp'%>
	<%@ include file='/WEB-INF/views/include/search.jsp'%>
	<div class="confirmPayPageDiv">
		<div class="confirmPayImageDiv">
			<img src="img/site/comformPayFlow.png">
			<div class="confirmPayTime1">
				<fmt:formatDate value="${order.createdate }" type='both' />
			</div>
			<div class="confirmPayTime2">
				<fmt:formatDate value="${order.paydate }" type='both' />
			</div>
			<div class="confirmPayTime3">
				<fmt:formatDate value="${order.deliverydate }" type='both' />
			</div>
		</div>
		<div class="confirmPayOrderInfoDiv">
			<div class="confirmPayOrderInfoText">我已收到货，同意支付宝付款</div>
		</div>
		<div class="confirmPayOrderItemDiv">
			<div class="confirmPayOrderItemText">订单信息</div>
			<table class="confirmPayOrderItemTable">
				<thead>
					<tr>
						<th colspan="2">宝贝</th>
						<th width="120px">单价</th>
						<th width="120px">数量</th>
						<th width="120px">商品总价</th>
						<th width="120px">运费</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items='${order.orderItems }' var='oi'>
						<tr>
							<td>
								<img width="50px" src="img/productSingle/${oi.product.firstProductImage.id }.jpg">
							</td>
							<td class="confirmPayOrderItemProductLink">
								<a href="front/product?id=${oi.product.id }">${oi.product.name }</a>
							</td>
							<td>
								￥
								<fmt:formatNumber value='${oi.product.promoteprice }' minFractionDigits="2"></fmt:formatNumber>
							</td>
							<td>${oi.number }</td>
							<td>
								<span class="conformPayProductPrice">
									￥
									<fmt:formatNumber value="${oi.number*oi.product.promoteprice }" minFractionDigits="2"></fmt:formatNumber>
								</span>
							</td>
							<td>
								<span>快递 ： 0.00 </span>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="confirmPayOrderItemText pull-right">
				实付款：
				<span class="confirmPayOrderItemSumPrice">
					￥
					<fmt:formatNumber value="${order.total }" minFractionDigits="2"></fmt:formatNumber>
				</span>
			</div>
		</div>
		<div class="confirmPayOrderDetailDiv">
			<table class="confirmPayOrderDetailTable ">
				<tbody>
					<tr>
						<td>订单编号：</td>
						<td>
							${order.ordercode }
							<img width="23px" src="img/site/confirmOrderTmall.png">
						</td>
					</tr>
					<tr>
						<td>卖家昵称：</td>
						<td>
							天猫商铺
							<span class="confirmPayOrderDetailWangWangGif"></span>
						</td>
					</tr>
					<tr>
						<td>收货信息：</td>
						<td>${order.address }，${order.receiver }，${order.mobile }，${order.post }</td>
					</tr>
					<tr>
						<td>成交时间：</td>
						<td>
							<fmt:formatDate value="${order.createdate }" type='both' />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="confirmPayButtonDiv">
			<div class="confirmPayWarning">请收到货后，再确认收货！否则您可能钱货两空！</div>
			<a href="front/confirmed?oid=${order.id }">
				<button class="confirmPayButton">确认支付</button>
			</a>
		</div>
		<%@include file='/WEB-INF/views/include/loginModal.jsp'%>
	</div>
	<%@include file='/WEB-INF/views/include/bottom.jsp'%>
</body>
</html>