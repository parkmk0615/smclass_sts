<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h2>메인페이지</h2>
	
	
	<c:forEach items="${list}" var="mdto">
		<ul>${mdto.id}</ul>
	</c:forEach>
	<ul><a href="login">로그인</a></ul>
	<ul><a href="logout">로그아웃</a></ul>
</body>
</html>