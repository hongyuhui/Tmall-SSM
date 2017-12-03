<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	
}

div.searchbody {
	positon: relative;
	height: 80px;
	margin: 5px auto;
	width: 1080px;
}

img.search {
	display:inline-block;
	width:200px;
	height:60px;
}

.search {
	width: 400px;
	height: 36px;
	margin: 0px auto;
	padding: 1px;
	display: inline-block;
}

.keyword {
	width: 275px;
	height: 36px;
	border: 1px solid transparent;
	outline: none !important;
}

.searchtmallred {
	background-color: #C40000 !important;
	padding: 2px 2px;
}

.searchbutton {
	width: 110px;
	border: 1px solid transparent;
	background-color: #C40000;
	color: white;
	font-size: 20px;
	font-weight: bold;
	margin: 3px 0px;
}

.search div span {
	color: #999;
}

.searchBelow a {
	color: #999;
}

div.searchBelow {
	margin-top: 3px;
	margin-left: -20px;
}

div.searchBelow a {
	padding: 0px 20px 0px 20px;
	font-size: 14px;
}

.searchBelow a:hover {
	text-decoration: none;
	color: #C40000;
}
</style>
<script type="text/javascript">
	$(function() {
		var flag = "${empty categories}";
		if (flag == "true") {
			$.get("front/getCategory", function(result) {
			});
		}
	});
</script>
</head>
<body>
	<div class="searchbody">
		<a href="front/home">
			<img class='search' alt="" src="img/site/logo.gif">
		</a>
		<form action="front/search" style="display:inline-block;float:right;">
			<div class="search searchtmallred">
				<input style='padding: 2px; height: 30px;' name='keyWord' value='${param.keyWord }' type="text" class="pull-left keyword" placeholder="篮球鞋">
				<button type="submit" class='searchbutton'>搜索</button>
				<div class='pull-left searchBelow'>
					<c:forEach items="${categories}" var="c" varStatus="st">
						<c:if test="${st.count>=8 and st.count<=11}">
							<span>
								<a href="front/category?id=${c.id}"> ${c.name} </a>
								<c:if test="${st.count!=11}">
									<span>|</span>
								</c:if>
							</span>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</form>
	</div>
</body>
</html>