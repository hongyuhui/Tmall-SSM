<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类属性</title>
<style type='text/css'>
div.main {
	width: 1080px;
	margin: 0 auto;
}

table {
	width: 100%
}

table tr td {
	text-align: center;
	font-size: 16px;
}

div.add-Title {
	line-height: 30px;
	background-color: #C0C0C0;
	margin-bottom: 10px;
}
th {
	text-align: center;
}

.addProperty {
	width: 450px;
	margin: 0 auto;
	border: 1px solid #cccccc;
	border-radius: 4px;
}
</style>
</head>
<body>
	<div class='main'>
		<%@include file="../include/admin/adminNavigator.jsp"%>
		<div class='catalog'>
			<ul class="breadcrumb">
				<li><a href="category/list">分类管理</a></li>
				<li class='active'>${category.name }<span class="divider">/</span>
				</li>
				<li class='active'>属性</li>
			</ul>
		</div>
		<table class="table-striped table-hover table-bordered">
			<tr>
				<th>ID</th>
				<th>属性名称</th>
				<th>编辑属性</th>
				<th>删除属性</th>
			</tr>
			<c:forEach items="${properties}" var="item" varStatus="st">
				<tr>
					<td>${page.startRow-1+st.count}</td>
					<td>${item.name}</td>
					<td><a href="property/edit?id=${item.id}" class='glyphicon glyphicon-edit'></a></td>
					<td><a href="property/delete?id=${item.id}&cid=${item.cid}" class='glyphicon glyphicon-trash'></a></td>
				</tr>
			</c:forEach>
		</table>
		<%@include file="/WEB-INF/views/include/admin/Paging.jsp"%>
		<div class="addProperty">
			<div class='add-Title'>新增属性</div>
			<form action="property/add" method="GET" id="addProperty" class="form-horizontal">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">属性名称</label>
					<div class="col-sm-6">
						<input type="text" id="propertyName" name="name" placeholder="请输入属性名称"> <input type="hidden" name='cid' value='${category.id}'>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">添加</button>
					</div>
				</div>
			</form>
		</div>
		<%@include file="/WEB-INF/views/include/admin/adminFooter.jsp"%>
	</div>
</body>
</html>