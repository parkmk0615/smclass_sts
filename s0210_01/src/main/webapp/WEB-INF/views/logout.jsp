<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
<script>
	if("${chkLogin}"=="0"){
		alert("로그아웃이 되었습니다.")
		locatiob.href="/";
	}else{
		location.href="/";
	}
</script>
</head>
<body>

</body>
</html>