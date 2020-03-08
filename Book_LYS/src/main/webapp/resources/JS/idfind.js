
//아이디 찾기 - ajax이용

$(document).on("click","#idfind",function(){
	
	//입력 한 이름 
	var name = $("#name").val();
	
	//입력 한 핸드폰 번호
	var phone = $("#phone").val();
	
	var postData  = {"name" : name,"phone" : phone};
	
	$.ajax({
		url : "FINDID",
		type : "POST",
		async : false,
		data : postData,
		dataType : "text",
		
		//url의 통해서 처리 된 결과 매개변수로 전달.
		success : function(data){
			//alert("data : "+data); 
			
			var result = confirm("회원님의 email은"+data+"입니다.전송 할까요?");
			
			if(result){
				//post 형식으로 mail url로 이동 -----------------------
				$('#form1').attr({action:'mail', method:'post'}).submit(); //페이지 이동 , 회원 가입 등록
			}else{
				location.replace("id_pwChk");//취소 할 경우 현재 페이지 유지
			}
		},
		error : function(request,status,error){
			//error 확인
			//alert("code = "+ request.status + " message = " +
					//request.responseText + " error = " + error);

			alert("잘못 입력되었습니다.다시 확인 해 주세요.");
			location.replace("id_pwChk");
		}
		
	});
});
