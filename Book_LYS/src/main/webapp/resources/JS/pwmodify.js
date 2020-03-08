

$(document).on("click","#pwfind",function(){
	

	//입력 한 id
	var userid = $("#userid").val();
	
	//입력 한 email
	var email = $("#email").val();
	
	var postData = {"userid" : userid , "email" : email};
	
	$.ajax({
		url : "ModifyPW",
		type : "POST",
		async : false,
		data : postData,
		dataType : "json",
		
		success : function(data){
			//alert("data = "+data);
			
			if(data == 1){
				alert("Email로 인증번호를 발송 합니다.");
				$('#form2').attr({action:'mailnum', method:'post'}).submit();
				$('#pwfind').attr("value","1");
				//alert("버튼 : "+$('#pwfind').val());
			}else if($("#userid").val() == '' & $("#email").val() == ''){
				alert("ID와 Email을 입력 해 주세요");
			}else{
				alert("회원이 아닙니다. 회원 가입 해 주세요.");
			}
		},
		error : function(request,status,error){
			alert("code = "+ request.status + " message = " +
				request.responseText + " error = " + error);
			alert("잘못 입력되었습니다.다시 확인 해 주세요.");
			location.replace("id_pwChk");
		}
	});
});