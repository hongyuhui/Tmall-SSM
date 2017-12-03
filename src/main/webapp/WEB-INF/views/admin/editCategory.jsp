<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/admin/adminHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑分类属性</title>
<style type="text/css">
div.main {
	width: 1080px;
	margin: 0 auto;
}

<<<<<<< HEAD
.addCategory {
	padding-left:40%
=======
.control-group {
	text-align: center;
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
}
</style>
</head>
<body>
	<div class='main'>
		<%@include file="/WEB-INF/views/include/admin/adminNavigator.jsp"%>
		<div class='catalog'>
			<ul class="breadcrumb">
<<<<<<< HEAD
				<li><a href="category/list">分类管理</a> <!-- <span class="divider">/</span> --></li>
				<li class='active'>分类编辑</li>
			</ul>
		</div>
		<div class="addCategory">
			<form action="category/update" enctype="multipart/form-data" method="POST" id="addCategory" class="form-horizontal">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">分类名称</span> <input type="text" id="categoryName" name="name" value="${requestScope.category.name}">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">分类图片</span><input type="file" accept="image/*" id="categoryImg" name="categoryImage" placeholder="图片">
				</div>

				<div class="input-group">
=======
				<li>
					<a href="admin_category_list">分类管理</a>
					<span class="divider">/</span>
				</li>
				<li class='active'>分类编辑</li>
			</ul>
		</div>
		<div class=" offset3 span6 addCategory">
			<form action="category/update" enctype="multipart/form-data" method="POST" id="addCategory" class="form-horizontal">
				<div class="control-group">
					<label class="control-label" for="categoryName">分类名称</label>
					<div class="controls">
						<input type="text" id="categoryName" name="name" value="${requestScope.category.name}">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="categoryImg">分类图片</label>
					<div class="controls">
						<input type="file" accept="image/*" id="categoryImg" name="categoryImage" placeholder="图片">
					</div>
				</div>
				<div class="control-group">
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
					<input type="hidden" name="id" value="${requestScope.category.id}">
					<button type="submit" class="btn">提交</button>
				</div>
			</form>
		</div>
<<<<<<< HEAD
	</div>
	<%@include file="/WEB-INF/views/include/admin/adminFooter.jsp"%>
=======
		<%@include file="/WEB-INF/views/include/admin/adminFooter.jsp"%>
>>>>>>> 9c7098800e429f9ed11452cc7d640633f484d820
	</div>

</body>
</html>