<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.brandImg {
	width: 20px;
	height: 20px;
	display: inline-block;
}
</style>
<script type="text/javascript">
$(function(){
	$(".navigation").click(function(){
		$(this).attr("class","navigation active");
	})
})
</script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- 	<img alt="小卖部" src="img/site/tmallbuy.png" class="brandImg"> -->
				<a class="navbar-brand" href="#">商城后台管理</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="navigation">
						<a href="category/list">
							分类管理
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li class="navigation">
						<a href="order/list">
							订单管理
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li class="navigation">
						<a href="user/list">
							用户管理
							<span class="sr-only">(current)</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>