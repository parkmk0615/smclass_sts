<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메인페이지</h2>
	<h4>세선: ${session_id }</h4>
	<c:if test="${id==null }">
		<div><a href="/board">게시판</a></div>
		<div><a href="/stuinput">학생성적입력</a></div>
		<div><a href="/login">로그인</a></div>
	</c:if>
	
	<c:if test="${id !=null }">
		<div><a href="/logout">로그아웃</div>
	</c:if>
</body>
</html>