<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#upload{
	visibility: hidden;
}
</style>
</head>
<body>
<!-- 단순 submit -->
<form action="/chapter06_SpringWebMaven/user/upload" method="post" enctype="multipart/form-data">
	<input type="file" name="upload">
	<br><br>
	<input type="file" name="upload"><br>
	<input type="file" name="upload"> <!-- name 값을 똑같게 준다 -->
	<br><br>
	
	<h3>한번에 여러개 파일 선택</h3>
	<img id="camera" src="../image/camera.svg" width="50" height="50" alt="카메라"/>
	<input type="file" name="upload[]" id="upload" multiple>     <!-- 파일 여러개 올리기 -->
	<br><br>
	<input type="submit" id="uploadBtn" value="보내기">	
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
$("#camera").click(function(){
	$("#upload").trigger("click");
});
</script>

<!-- Ajax 통신 -->

</body>
</html>