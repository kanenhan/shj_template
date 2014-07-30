<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
	<a href="${path}/student/showInfo.do">添加</a>
	<table>
		<thead>
			<tr>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${students}" var="student">
			<tr>
				<td>${student.name}</td>
				<td>${student.age}</td>
				<td>${student.sex}</td>
				<td>
					<a href="${path}/student/showInfo.do?id=${student.id}">修改</a>
					<a href="${path}/student/deleteById.do?id=${student.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</html>