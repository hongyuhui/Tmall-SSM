<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/admin/adminHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品编辑</title>
<style type="text/css">
div.main {
	width: 1080px;
	margin: 0 auto;
}

.editProduct {
	width: 450px;
	margin: 0 auto;
	border: 1px solid #cccccc;
	border-radius: 4px;
}

div.add-Title {
	line-height: 30px;
	background-color: #C0C0C0;
	margin-bottom: 10px;
}

div.controls {
	display: inline-block;
}
</style>


</head>
<body>
	<div class='main'>
		<%@include file="/WEB-INF/views/include/admin/adminNavigator.jsp"%>
		<div class='catalog'>
			<ul class="breadcrumb">
				<li>
					<a href="category/list">分类管理</a>
				</li>
				<li>
					<a href="product/list?cid=${product.category.id }">${product.category.name}</a>
				</li>
				<li class='active'>产品编辑</li>
			</ul>
		</div>
		<div class="text-center editProduct">
			<div class='add-Title'>编辑产品</div>
			<form action="product/update" method="POST" id="editProduct" class="form-horizontal">
				<div class="control-group">
					<label class="control-label" for="productName">产品名称</label>
					<div class="controls">
						<input type="text" id="productName" name="name" value="${product.name }" placeholder="请输入产品名称">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="productKeyWord">产品关键字</label>
					<div class="controls">
						<input type="text" id="productKeyWord" name="subtitle" value="${product.subtitle }" placeholder="请输入产品关键字">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="producoriginalprice">原始价格</label>
					<div class="controls">
						<input type="text" id="producoriginalprice" name="originalprice" value="${product.originalprice }" placeholder="请输入产品原始价格">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="producPromotePrice">优惠价格</label>
					<div class="controls">
						<input type="text" id="producPromotePrice" name="promoteprice" value="${product.promoteprice }" placeholder="请输入产品优惠价格">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="productStock">产品库存</label>
					<div class="controls">
						<input type="text" id="productStock" name="stock" value="${product.stock }" placeholder="请输入产品库存">
					</div>
				</div>
				<div class="text-center control-group">
					<input type="hidden" name="cid" value="${product.category.id}">
					<input type="hidden" name="id" value="${product.id}">
					<button type="submit" class="btn">提交</button>
				</div>
			</form>
		</div>
		<%@include file="/WEB-INF/views/include/admin/adminFooter.jsp"%>
	</div>
</body>
</html>