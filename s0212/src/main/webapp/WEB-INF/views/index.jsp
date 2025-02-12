<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<script>
	if("${param.logout}"=="1"){
		alert("로그아웃 되었습니다.");
		location.href="/";
	}

</script>
</head>
<body>
	<h2>메인페이지</h2>
	<h4>세션: ${session_id }</h4>
	<h4>세션이름: ${session_name}님 환영합니다.</h4>
	<ul>
		<li><a href="/member/login">로그인</a></li>
		<li><a href="/member/logout">로그아웃<a/></li>
		<li><a href="/restpage">restController 데이터<a/></li>
		<li><a href="/rpage">Controller 데이터<a/></li>
		<li><a href="/board/blist">게시판</a></li>
		<li><a href="/board/bwrite">글쓰기</a></li>
		<li><a href="/member/member">회원가입<a/></li>
		<hr>
	</ul>
	<h3>이미지 보여짐</h3>
	<div>
		<img src="/upload/${param.fname }"/>
	</div>
</body>
</html>