<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file='/WEB-INF/views/include/admin/adminHeader.jsp'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<style>
div#loginDiv {
	width: 1080px;
	margin: 0 auto;
	position: relative;
}

div.simpleLogo {
	margin: 10px 0;
}

img.loginBackgroundImg {
	display: block;
	width: 1080px;
	margin: 0px auto;
}

div.loginSmallDiv1 {
	background-color: white;
	position: absolute;
	left: 600px;
	top: 50px;
	width: 350px;
	height: 300px;
	padding: 60px 25px 80px 25px;
}
.loginErrorMessageDiv{
display:none;
position:absolute;
top:5px;
}

div.login_acount_text {
	color: #3C3C3C;
	font-size: 16px;
	font-weight: bold;
}

form.loginForm div.input-group input#name {
	outline: none;
}

body {
	font-size: 12px;
	font-family: Arial;
}

a {
	color: #999;
}

a:hover {
	text-decoration: none;
	color: #C40000;
}

div#loginSmallDiv1 button.redButton {
	color: white;
	width: 300px;
	background-color: #C40000;
	border: 1px solid transparent;
	font-size: 18px;
	font-weight: bold;
}
</style>
<script>
$(function(){
     
    <c:if test="${!empty msg}">
    $("span.errorMessage").html("登录失败，请检查用户名和密码后再次尝试~");
    $("div.loginErrorMessageDiv").show();       
    </c:if>
     
    $("form.loginForm").submit(function(){
    	var n=$("#name").val().length;
    	var p=$("#password").val().length;
    	console.log(n+'---'+p);
        if(0==n||0==p){
            $("span.errorMessage").html("请输入账号密码");
            $("div.loginErrorMessageDiv").show();           
            return false;
        }
        return true;
    });
     
    $("form.loginForm input").keyup(function(){
        $("div.loginErrorMessageDiv").hide();   
    });
     
    var left = window.innerWidth/2+162;
    $("div.loginSmallDiv").css("left",left);
})
</script>
</head>
<body>
	<%@ include file='/WEB-INF/views/include/FrontTop.jsp'%>
	<div id="loginDiv">
		<div class="simpleLogo">
			<img src="img/site/simpleLogo.png">
		</div>
		<img src="img/site/loginBackground.png" class="loginBackgroundImg" id="loginBackgroundImg">
		<div class="loginSmallDiv1" id="loginSmallDiv1" style="left: 650px !important;">
			<div class="loginErrorMessageDiv" style='display: none;position:absolute;'>
				<div class="alert alert-danger">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
					<span class="errorMessage"></span>
				</div>
			</div>
			<form action="front/login" class='loginForm' method='POST'>
				<div class="login_acount_text">账户登录</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="手机/会员名/邮箱" name="name" id="name" aria-describedby="basic-addon1">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">
						<span class="glyphicon glyphicon-lock"></span>
					</span>
					<input type="password" class="form-control" placeholder="密码" name="password" id="password" aria-describedby="basic-addon1">
				</div>
				<div>
					<a href="#nowhere" class="notImplementLink">忘记登录密码</a>
					<a class="pull-right" href="front/registPage">免费注册</a>
				</div>
				<div style="margin-top: 20px; text-align: center;">
					<button type="submit" class=" redButton">登录</button>
				</div>
			</form>
		</div>
		<%@include file='/WEB-INF/views/include/loginModal.jsp'%>
	</div>
	<%@include file='/WEB-INF/views/include/bottom.jsp'%>
</body>
</html>