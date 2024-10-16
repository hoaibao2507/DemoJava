<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web khảo sát</title>
</head>
<body>
	<h2>Đây là website khảo sát SV</h2>
	<form action="/ltweb5/auth/login" method="post">
		<label>Tên đăng nhập: </label>
		<input type="text" name="username"><br>
		<label>Mật khẩu: </label>
		<input type="password" name="pw"><br>
		<input type="submit" value="Đăng nhập">
	</form>
	<div>
		<c:out value="${copyright}"/>
	</div>
</body>
</html>