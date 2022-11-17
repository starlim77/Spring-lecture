<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- post 방식으로 한글을 넘기면 오류난다 -->
<!-- <form action="result.do" method="post"> -->
<form action="result.do" method="post">
	<span>이름 : </span>
	<input type="text" name="name">
	<br>
	<span>국어 : </span>
	<input type="text" name="kor">
	<br>
	<span>영어 : </span>
	<input type="text" name="eng">
	<br>
	<span>수학 : </span>
	<input type="text" name="math">
	<br>
	<input type="submit">
</form>
</body>
</html>