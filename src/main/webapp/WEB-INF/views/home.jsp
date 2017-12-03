<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file='/WEB-INF/views/include/admin/adminHeader.jsp'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fun商城</title>
<link rel='stylesheet' href='css/home.css'>
<script type="text/javascript" src="js/home.js"></script>
</head>
<body>
	<%@ include file='/WEB-INF/views/include/FrontTop.jsp'%>
	<%@ include file='/WEB-INF/views/include/search.jsp'%>
	<div class='head'>
		<img class='catear' alt="" src="img/site/catear.png">
		<div class='topMenu'>
			<div class='productList'>
				<span class='glyphicon glyphicon-menu-hamburger'>商品分类</span>
			</div>
			<div class='rightMenu'>
				<span>
					<span class='glyphicon glyphicon-shopping-cart'></span>
					<a href='#'>Fun超市</a>
				</span>
				<span>
					<span class='glyphicon glyphicon-globe'></span>
					<a href='#'>Fun国际</a>
				</span>
				<span>
					<a href='#'>平板电视</a>
				</span>
				<span>
					<a href='#'>马桶</a>
				</span>
				<span>
					<a href='#'>沙发</a>
				</span>
				<span>
					<a href='#'>电热水器</a>
				</span>

			</div>
			<div style='clear: both;'></div>
		</div>
		<div style='clear: both;'></div>
		<div class='top-show'overflow:hidden;'>
			<!-- 轮播内容 -->
			<div id="myCarousel" class="carousel slide">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>
				<!-- Carousel items -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="img/lunbo/1.jpg">
					</div>
					<div class="item">
						<img src="img/lunbo/2.jpg">
					</div>
					<div class="item">
						<img src="img/lunbo/3.jpg">
					</div>

					<div class="item">
						<img src="img/lunbo/4.jpg">
					</div>
				</div>
				<!-- Carousel nav -->
				<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
				<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
			<!-- 轮播结束 -->
			<div style='position: absolute; top: 0; left: 0;'>
				<!-- 分类列表 -->
				<div class='list1'>
					<c:forEach items='${categories}' var='item'>
						<div class="eachCategory" cid="${item.id}">
							<span class="icon-align-justify"></span>
							<a href="front/category?id=${item.id }"> ${item.name} </a>
						</div>
					</c:forEach>
				</div>
				<!-- 分类产品列表 -->
				<div class='list2' style="position: relative; left: 0; top: 0;">
					<!-- 遍历分类，一个分类一个div -->
					<c:forEach items='${categories }' var='category'>
						<div class="productsAsideCategorys" cid="${category.id }" style="display: none;">
							<!-- 遍历分类产品 -->
							<c:forEach items='${category.productsByRow }' var='item'>
								<!-- 遍历产品 8个-->
								<c:forEach items='${item}' var='product'>


									<c:if test="${!empty product.subtitle }">
										<c:forEach items="${fn:split(product.subtitle,' ') }" var='title' varStatus='st'>
											
												<a class='subtitle' href="front/product?id=${product.id }"> ${title } </a>
										</c:forEach>
									</c:if>
								</c:forEach>
								<div class="seperator"></div>
							</c:forEach>

						</div>
					</c:forEach>
				</div>
				<div style='clear: both;'></div>
			</div>
		</div>
		<%@include file='/WEB-INF/views/include/loginModal.jsp'%>
	</div>
	<div style="clear: both;"></div>
	<!-- 主页产品展示列表 -->
	<%@ include file='/WEB-INF/views/include/homePageProduct.jsp'%>

	<%@include file='/WEB-INF/views/include/bottom.jsp'%>
</body>
</html>