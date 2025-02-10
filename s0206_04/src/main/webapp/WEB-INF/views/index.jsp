<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h2>메인페이지</h2>
	
	
	<c:if test="${id2==null}">
		<div><a href="/login">로그인</a></div>
		<div><a href="/member">회원가입</div>
		<div><a href="/stuinput">학생성적입력</div>
		<div><a href="/data1?bno=10">데이터1</div>
		<div><a href="/data2/100">데이터2</div>
		<div><a href="/data3/1,2,3">데이터3</div>
		<div><a href="/data4">데이터4</div>
	</c:if>
	
	<c:if test="${id2 !=null}">
		<div><a href="/logout">로그아웃</div>
		<div><a href="/board">게시판</div>
		<div><a href="/meminfo">회원정보</div>
	</c:if>
</body>
</html>