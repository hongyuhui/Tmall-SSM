<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file='/WEB-INF/views/include/admin/adminHeader.jsp'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
<style type="text/css">
div.registerSuccessDiv {
	text-align: center;
	width:1080px;
	margin:100px auto;
	background-color: #F3FDF6;
	font-weight: bold;
}
</style>
</head>
<body>
	<%@ include file='/WEB-INF/views/include/FrontTop.jsp'%>
	<%@ include file='/WEB-INF/views/include/search.jsp'%>
	<div class="registerSuccessDiv">
		<img src="img/site/registerSuccess.png">
		恭喜注册成功
		<%@include file='/WEB-INF/views/include/loginModal.jsp'%>
	</div>
	
	<%@ include file='/WEB-INF/views/include/bottom.jsp'%>
</body>
</html>