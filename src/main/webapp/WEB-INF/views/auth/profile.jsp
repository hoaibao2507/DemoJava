<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin đăng nhập</title>
</head>
<body>
	<h1>Xin chào <c:out value="${name}"/></h1>
	<form action="/ltweb5/auth/logout" method="post">
		<input type="submit" value="Đăng xuất">
	</form>
</body>
</html>