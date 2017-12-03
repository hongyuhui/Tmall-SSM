<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	font-size: 12px;
}

nav.top span {
	margin: 0px 5px;
}

nav.top {
	background-color: #f2f2f2;
	padding: 5px 0px;
	border-bottom: 1px solid #e7e7e7;
}

nav.top, nav.top a {
	color: #888;
}

nav.top a:hover {
	color: #C40000;
	text-decoration: none;
}

.tmallred {
	color: #C40000 !important;
}
</style>
<script type="text/javascript">
	$(function() {
		$('#userLogout').click(function() {
			$.get("front/logout", function(result) {
				if (result == "success") {
					location.reload();
				}
			});
			return false;
		});
		$.get("front/carTotalNumber",function(result){
			
		});
	});
</script>
</head>
<body>
	<nav class='top'> <span class='glyphicon glyphicon-home tmallred'></span> <span>
		<a href="front/home">天猫首页</a>
	</span> <span>喵~欢迎来到天猫！</span> <c:if test="${!empty sessionScope.user }">
		<span>
			欢迎
			<a href="front/loginPage">${sessionScope.user.name }</a>
		</span>
		<span>
			<a href="front/logout" id="userLogout">退出</a>
		</span>
	</c:if> <c:if test="${empty sessionScope.user }">
		<span>
			请
			<a href="front/loginPage">登录</a>
		</span>
		<span>
			<a href="front/registPage">免费注册</a>
		</span>
	</c:if> <span class="pull-right">
		<a href="front/cart" class='shoppingCart'>
			<span class="glyphicon glyphicon-shopping-cart tmallred"></span>

			购物车
			<span style="margin: 0px;">${carTotalNumber!=null?carTotalNumber:0}</span>
			件
		</a>
	</span> <span class="pull-right">
		<a href="front/myOrder">我的订单</a>
	</span></nav>
</body>
</html>