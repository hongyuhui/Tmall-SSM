<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/admin/adminHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品图片管理</title>
<style type="text/css">
.main {
	width: 1080px;
	margin: 0 auto;
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

.type_single, .type_detail {
	float: left;
	width: 400px;
	margin: 20px 30px;
}

</style>
<script type="text/javascript">
	$(function() {
		$("#addSingleImage").submit(function() {
			if (!checkEmpty("singleImage", "图片")) {
				return false;
			}
		});
		$("#addDetailImage").submit(function() {
			if (!checkEmpty("detailImage", "图片")) {
				return false;
			}
		});
	});
</script>
</head>
<body>
	<div class='main '>
		<%@include file="/WEB-INF/views/include/admin/adminNavigator.jsp"%>
		<div class='catalog'>
			<ul class="breadcrumb">
				<li>
					<a href="category/list">分类管理</a>
<<<<<<< HEAD
				</li>
				<li>
					<a href="product/list?cid=${product.category.id}">${product.category.name}</a>
				</li>
				<li class="active">
					${product.name}
=======
					<span class="divider">/</span>
				</li>
				<li>
					<a href="product/list?cid=${product.category.id}">${product.category.name}</a>
					<span class="divider">/</span>
				</li>
				<li class="active">
					${product.name}
					<span class="divider">/</span>
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
				</li>
				<li class="active">产品图片管理</li>
			</ul>
		</div>
		<div class='type_single'>
			<form action="productImages/add" method="post" enctype='multipart/form-data' id="addSingleImage">
				<fieldset>
					<legend>添加展示图片</legend>
					<input type="file" name='productImage' id="singleImage">
					<input type="hidden" name='type' value='type_single'>
					<input type="hidden" name='pid' value='${product.id}'>
					<span class="help-block">此图片用于产品展示</span>
					<button type="submit" class="btn">提交</button>
				</fieldset>
			</form>
			<table class='table text-center'>
				<caption>产品展示图片</caption>
				<tr>
					<th>序号</th>
					<th>缩略图</th>
					<th>删除</th>
				</tr>
				<c:forEach items="${singleImages }" var="item" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td >
							<img src='img/productSingle/${item.id}.jpg' style='width: 60px; height: 60px;'>
						</td>
						<td>
<<<<<<< HEAD
							<a href='productImages/delete?id=${item.id }&pid=${product.id}' class='glyphicon glyphicon-trash'></a>
=======
							<a href='productImages/delete?id=${item.id }&pid=${product.id}' class='icon-trash'></a>
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class='type_detail'>
			<form action="productImages/add" method="post" enctype='multipart/form-data' id="addDetailImage">
				<fieldset>
					<legend>添加商品详情图片</legend>
					<input type="file" name='productImage' accept="image" id="detailImage">
					<input type="hidden" name='type' value='type_detail'>
					<input type="hidden" name='pid' value='${product.id}'>
					<span class="help-block">此图片用于商品详情.</span>
					<button type="submit" class="btn">提交</button>
				</fieldset>
			</form>
			<table class='table'>
				<caption>产品详情图片</caption>
				<tr>
					<th>序号</th>
					<th>缩略图</th>
					<th>删除</th>
				</tr>
				<c:forEach items="${detailImages }" var="item" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td >
							<img src='img/productDetail/${item.id}.jpg' style='width: 60px; height: 60px;'>
						</td>
						<td>
<<<<<<< HEAD
							<a href='productImages/delete?id=${item.id }&pid=${product.id}' class='glyphicon glyphicon-trash'></a>
=======
							<a href='productImages/delete?id=${item.id }&pid=${product.id}' class='icon-trash'></a>
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style='clear: both;'></div>
		<%@include file="/WEB-INF/views/include/admin/adminFooter.jsp"%>
	</div>
</body>
</html>