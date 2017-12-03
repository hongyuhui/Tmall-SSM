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
.addCategory {
	padding-left:40%
}
</style>
</head>
<body>
	<div class='main'>
		<%@include file="/WEB-INF/views/include/admin/adminNavigator.jsp"%>
		<div class='catalog'>
			<ul class="breadcrumb">
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
					<input type="hidden" name="id" value="${requestScope.category.id}">
					<button type="submit" class="btn">提交</button>
				</div>
			</form>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/admin/adminFooter.jsp"%>
	</div>

</body>
</html>