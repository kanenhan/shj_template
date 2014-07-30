<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%
	request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
	<form action="${path}/student/submit.do" method="post">
		<input name="id" type="hidden" value="${student.id}" />
		<label>姓名:</label><input name="name" value="${student.name}" /> <br/>
		<label>年龄:</label><input name="age" value="${student.age}" /> <br/>
		<label>性别:</label><input name="sex" value="${student.sex}" /> <br/>
		<input type="submit" value="提交" />
	</form>
</html>