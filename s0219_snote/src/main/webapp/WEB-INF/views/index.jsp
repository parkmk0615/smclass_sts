<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메인페이지</h2>
	<h4>세션: ${session_id }</h4>
	<h4>세션이름: ${session_name}님 환영합니다.</h4>
	<ul>
		<li><a href="/member/login">로그인</a></li>
		<li><a href="/member/logout">로그아웃<a/></li>
		<li><a href="/member/member">회원가입<a/></li>
		<li><a href="/board/blist">게시판</a></li>
		<li><a href="/bwrite">글쓰기</a></li>
		<li><a href="/bview?bno=29">상세보기</a></li>
		<hr>
	</ul>
</body>
</html>