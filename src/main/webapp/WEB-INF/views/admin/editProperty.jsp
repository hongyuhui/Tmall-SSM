<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/admin/adminHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类属性编辑</title>
<style type="text/css">
div.main {
	width: 1080px;
	margin: 0 auto;
}

.editProperty {
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
					<a href="property/list?cid=${property.category.id }">${property.category.name }属性</a>
				</li>
				<li class='active'>分类属性编辑</li>
			</ul>
		</div>
		<div class="editProperty">
			<div class='add-Title'>
				<span>编辑属性</span>
			</div>
			<form action="property/update" method="POST" id="addProperty" class="form-inline form-horizontal">
				<div class="control-group">
					<label class="control-label" for="propertyName">属性名称</label>
					<div class="controls" style="display:inline-block;">
						<input type="text" id="propertyName" name="name" value='${property.name }' placeholder="请输入属性名称">
						<input type="hidden" name='id' value='${property.id }'>
						<input type="hidden" name='cid' value='${property.category.id}'>
					</div>
				</div>
				<div class="text-center control-group">
					<button type="submit" class="btn">提交</button>
				</div>
			</form>
		</div>

		<%@include file="/WEB-INF/views/include/admin/adminFooter.jsp"%>
	</div>
</body>
</html>