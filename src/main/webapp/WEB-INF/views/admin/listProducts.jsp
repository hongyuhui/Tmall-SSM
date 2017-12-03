<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="../include/admin/adminHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类产品列表</title>
<style type="text/css">
.main {
	width: 1080px;
	margin: 0 auto;
<<<<<<< HEAD
	margin-bottom:200px; 
=======
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
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

div.add-Title {
	line-height: 30px;
	background-color: #C0C0C0;
	margin-bottom: 10px;
}

<<<<<<< HEAD
form div {
	display: inline-block;
}

=======
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
.addProduct {
	width: 450px;
	margin: 0 auto;
	border: 1px solid #cccccc;
	border-radius: 4px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#addProduct").submit(function() {
			if (!checkEmpty("productName", "产品名称")) {
				return false;
			}
			if (!checkNumber("producOriginalPrice", "原始价格")) {
				return false;
			}
			if (!checkNumber("producPromotePrice", "优惠价格")) {
				return false;
			}
			if (!checkInt("productStock", "产品库存")) {
				return false;
			}
		});
	});
</script>
</head>
<body>
	<div class='main'>
<<<<<<< HEAD
		<%@include file="/WEB-INF/views/include/admin/adminNavigator.jsp"%>
		<div class='catalog'>
			<ul class="breadcrumb">
				<li><a href="category/list">分类管理</a></li>
				<li class="active">${category.name}</li>
				<li class="active">产品列表</li>
=======
		<%@include file="../include/admin/adminNavigator.jsp"%>
		<div class='catalog'>
			<ul class="breadcrumb">
				<li>
					<a href="category/list">分类管理</a>
					<span class="divider">/</span>
				</li>
				<li class="active">${category.name}</li>
				<li class="active">
					<span class="divider">/</span>
					产品列表

				</li>
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
			</ul>
		</div>
		<div class='categorydiv'>
			<table class="table-striped table-hover table-bordered">
				<tr>
					<th>ID</th>
					<th>图片</th>
					<th>产品名称</th>
					<th>产品关键字</th>
					<th>原价格</th>
					<th>优惠价格</th>
					<th>产品库存</th>
					<th>编辑产品</th>
					<th>图片管理</th>
					<th>属性管理</th>
					<th>删除</th>
				</tr>
				<c:forEach items="${products}" var="product" varStatus="st">
					<tr>
						<td>${page.startRow+st.index}</td>
<<<<<<< HEAD
						<td><img class="categoryImg" style='width: 80px; height: 60px;' src="img/productSingle/${product.firstProductImage.id}.jpg"></td>
=======
						<td>
							<img class="categoryImg" style='width: 80px; height: 60px;' src="img/productSingle/${product.firstProductImage.id}.jpg">
						</td>
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
						<td>${product.name}</td>
						<td>${product.subtitle}</td>
						<td width=70px>${product.originalprice}</td>
						<td width=70px>${product.promoteprice}</td>
						<td width=70px>${product.stock}</td>
<<<<<<< HEAD
						<td width=70px><a href="product/edit?id=${product.id}" class='glyphicon glyphicon-list'></a></td>
						<td width=70px><a href="productImages/list?id=${product.id}" class='glyphicon glyphicon-edit'></a></td>

						<td width=70px><a href="propertyValue/list?pid=${product.id}" class='glyphicon glyphicon-list'></a></td>
						<td width=40px><a href="product/delete?id=${product.id}&cid=${category.id}" class='glyphicon glyphicon-trash'></a></td>
=======
						<td width=70px>
							<a href="product/edit?id=${product.id}" class='icon-list'></a>
						</td>
						<td width=70px>
							<a href="productImages/list?id=${product.id}" class='icon-edit'></a>
						</td>

						<td width=70px>
							<a href="propertyValue/list?pid=${product.id}" class='icon-list'></a>
						</td>
						<td width=40px>
							<a href="product/delete?id=${product.id}&cid=${category.id}" class='icon-trash'></a>
						</td>
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
					</tr>
				</c:forEach>
			</table>
		</div>
		<%@include file="../include/admin/Paging.jsp"%>
		<div class="text-center addProduct">
			<div class='add-Title'>新增产品</div>
			<form action="product/add" method="POST" id="addProduct" class="form-horizontal">
				<div class="control-group">
					<label class="control-label" for="productName">产品名称</label>
					<div class="controls">
						<input type="text" id="productName" name="name" placeholder="请输入产品名称">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="productKeyWord">产品关键字</label>
					<div class="controls">
						<input type="text" id="productKeyWord" name="subtitle" placeholder="请输入产品关键字">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="producOriginalPrice">原始价格</label>
					<div class="controls">
						<input type="text" id="producOriginalPrice" name="originalprice" placeholder="请输入产品原始价格">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="producPromotePrice">优惠价格</label>
					<div class="controls">
						<input type="text" id="producPromotePrice" name="promoteprice" placeholder="请输入产品优惠价格">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="productStock">产品库存</label>
					<div class="controls">
						<input type="text" id="productStock" name="stock" placeholder="请输入产品库存">
					</div>
				</div>
<<<<<<< HEAD
				<div class="text-center control-group" style="display:block;">
=======
				<div class="text-center control-group">
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
					<input type="hidden" name="cid" value="${category.id}">
					<button type="submit" class="btn">提交</button>
				</div>
			</form>
		</div>
		<%@include file="../include/admin/adminFooter.jsp"%>
	</div>
</body>
</html>