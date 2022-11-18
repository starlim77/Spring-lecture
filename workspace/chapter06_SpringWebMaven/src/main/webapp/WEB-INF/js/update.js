$("#updateId").focusout(function(){

		$("#writeForm").hide();
		$("#updateIdDiv").text("");
		
	$.ajax({
		type : "post",
		url : "/chapter06_SpringWebMaven/user/getUpdateUser",
		data : "id=" + $("#updateId").val(),
	//	dataType : "json",  
	    //dataType을 빼면 controller가 넘겨주는대로 받는다
	    //dataType을 생략하면 자료에 맞게 자동으로 형식이 지정된다.
		success : function(data){
		//	alert(JSON.stringify(data)); UserDTO가 null 이면    ""
		//	var name = data.name;
		//	var id = data.id;
			if(data==""){
				$("#updateIdDiv").text("찾고자 하는 아이디가 없습니다");
			}else{
				$("#writeForm").show();
				$("#name").val(data.name);
				$("#id").val(data.id);
			}
		},
		error : function(err){
			console.log(err);
		}
	});
});

//취소 버튼
$("#resetBtn").click(function(){
	//강제 이벤트 발생
	$("#updateId").trigger("focusout");
});
