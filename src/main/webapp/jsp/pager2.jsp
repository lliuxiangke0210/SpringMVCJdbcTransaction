<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <%   String url=request.getParameter("url");        %>
      

<div class="pagination pagination-small pagination-centered">
	<ul>
		<li><a href="<%=url %>?curPage=${datas.beginIndex}">Fisrt</a></li>
		<li><a href="<%=url %>?curPage=${datas.prePage}">Prev</a></li>
		<c:forEach var="i" items="${datas.slider }">
			<c:if test="${i<=datas.lastIndex}">
				<li><a href="<%=url %>?curPage=${i}">${i}</a></li>
			</c:if>
		</c:forEach>
		<li><a href="<%=url %>?curPage=${datas.nextPage}">Next</a></li>
		<li><a href="<%=url %>?curPage=${datas.lastIndex}">Last</a></li>
	</ul>
</div>