
//로그인 하지 않고 주문 목록 접근 
$("#my").click(function(){
	
	var userid=$(this).attr('value');
	
	if(userid == ""){
		alert("회원이 아닙니다. login 해 주세요");
		$("#my").attr("href","member/login");
	}
	
});

//로그인 하지 않고 board 접근
$("#board").click(function(){
	
	var userid=$(this).attr('value');
	
	if(userid == ""){
		alert("회원이 아닙니다. login 해 주세요");
		$("#board").attr("href","member/login");
	}
	
});

//로그인 하지 않고 cart 접근
$("#cart").click(function(){
	
	var userid=$(this).attr('value');
	
	if(userid == ""){
		alert("회원이 아닙니다. login 해 주세요");
		$("#cart").attr("href","member/login");
	}
	
});


