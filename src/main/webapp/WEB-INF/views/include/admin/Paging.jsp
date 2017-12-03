<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	/*分页不可点击设置*/
	$(function() {
		$(".disabled a").attr("href", "javascript:void(0)");
		$(".active a").attr("href", "javascript:void(0)");
	})
</script>
</head>
<body>

	<!-- 搭配mybatis pageHelper使用，page为pageHelper包下pageIfo对象，详情见github -->
	<nav aria-label="Page navigation" class="text-center ">
	<ul class="pagination">
		<li <c:if test="${!page.hasPreviousPage}">class="disabled"</c:if>>
			<a href="${uri}?start=0&${condition}">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
		<li <c:if test="${!page.hasPreviousPage}">class="disabled"</c:if>>
			<!-- SQL语句的limit 0,5表示从第1个开始取5个，page对象的StartRow是从1开始 -->
			<a href="${uri}?start=${page.startRow-1-page.pageSize}&${condition}" aria-label="Previous">
				<span aria-hidden="true"><</span>
			</a>
		</li>
		<c:forEach begin="0" end="${(page.pages-1)>0?(page.pages-1):0 }" varStatus="status">
			<!-- 判断当前是否为当前页，通过当前的page.startRow与分页计算出的page.satrt是否相等 -->
			<c:if test="${status.count<=10 }">
				<li <c:if test="${page.startRow==status.index*page.pageSize+1}">class="active"</c:if>>
					<a href="${uri}?start=${status.index*page.pageSize}&${condition}">${status.count}</a>
				</li>
			</c:if>
			<c:if test="${status.last&&status.count>10}">
				<li>
					<a>...</a>
				</li>
				<li <c:if test="${page.startRow==status.index*page.pageSize+1}">class="active"</c:if>>
					<a href="${uri}?start=${status.index*page.pageSize}&${condition}">${status.count}</a>
				</li>
			</c:if>
		</c:forEach>
		<li <c:if test="${!page.hasNextPage}">class="disabled"</c:if>>
			<a href="${uri}?start=${page.startRow+page.pageSize-1}&${condition}" aria-label="Next">
				<span aria-hidden="true">></span>
			</a>
		</li>
		<li <c:if test="${!page.hasNextPage}">class="disabled"</c:if>>
			<a href="${uri}?start=${(page.pages-1)*page.pageSize}&${condition}" aria-label="Next">
				<span aria-hidden="true">&raquo;</span>
			</a>
		</li>
	</ul>
	</nav>
</body>
</html>