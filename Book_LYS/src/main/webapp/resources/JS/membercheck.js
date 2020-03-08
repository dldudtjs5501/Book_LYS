	
	//ID 입력 시 길이 및 대/소문자/숫자 유효검사
	$("#idchk").keyup(function(){
		
		var idchk = $("#idchk").val(); //id값
		var id= RegExp(/^[a-zA-Z0-9]{5,20}$/); //대소문자 유효검사 , 길이도 같이 적용
		
		if(!id.test(idchk)){
			$("#idmsg").html("형식에 맞게 입력 해 주세요.");
			return false;
		}
		else{
			$("#idmsg").html("사용 가능 합니다.");
		}
		
	});

	//ID 중복 체크 및 유효성 검사(공백 일 경우)
	$("#btn_idchk").click(function(){
	
		var idchk = $("#idchk").val(); //id값
		var idChkVal = $("#btn_idchk").val(); //중복 버튼 값(value)
		
		if($("#idchk").val() == ""){
			//alert("아이디를 입력 해 주세요");
			//$("#idchk").focus();
			$("#idmsg").html("ID 입력 해 주세요");
			return false;
		}
		$.ajax({
			url : "IDCHK",
			type : "POST",
			async: false,
			data : {"userid" : $("#idchk").val()},
			dataType : "json",
			success : function(data){
				if(data == 1){		
					$("#idmsg").html("중복 된 아이디 입니다.");
					$("#idchk").val(""); //빈 값 적용 , 입력 란 reset
				}else if(data == 0){
					$("#btn_idchk").attr("value","Y");
					$("#idchk").attr("readOnly",true);
					$("#idmsg").html("사용 가능한 아이디 입니다.");
				}
			}
		
		});
		
	});
	
	//password 입력 시 길이 및 대/소문자/숫자 유효검사
	$("#pw").keyup(function(){
		var pw = $("#pw").val(); 
		var pass= RegExp(/^[a-zA-Z0-9]{4,20}$/);
		
		var password = $("#pw").val();
		var passwordchk = $("#pwchk").val();
		
		if(password == passwordchk){
			$("#pwchkmsg").html("일치합니다.");
		}else{
			$("#pwchkmsg").html("틀렸습니다.다시 입력 해 주세요.");
			$("#pwchkmsg").val("");
		}
		
		if(!pass.test(pw)){
			$("#pwmsg").html("형식에 맞게 입력 해 주세요.");
			return false;
		}else{
			$("#pwmsg").html("사용 가능 합니다.");
		}
		
	});
	
	//패스워드 재확인
	$("#pwchk").keyup(function(){
		var password = $("#pw").val();
		var passwordchk = $("#pwchk").val();
		
		
		//password recheck
		if(password == passwordchk){
			$("#pwchkmsg").html("일치합니다.");
		}else{
			$("#pwchkmsg").html("틀렸습니다.다시 입력 해 주세요.");
			$("#pwchkmsg").val("");
		}
	});
	
	//E-mail 유효 검사
	$("#email").keyup(function(){
		var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		
		if(!$("#email").val()){
			$("#emailchk").html("이메일을 입력 해 주세요.");
			return false;
		}
		if(!filter.test($("#email").val())){
			$("#emailchk").html("이메일 주소가 유효하지 않습니다.");
		}else{
			$("#emailchk").html("이메일 주소가 유효합니다.");
		}
	});
	
	//name 유효검사
	$("#namechk").keyup(function(){
		var named= RegExp(/^[A-Z가-힣]+$/);
		
		if(!named.test($("#namechk").val())){
			$("#namemsg").html("형식에 맞게 입력 해 주세요.");
			return false;
		}else{
			$("#namemsg").html("사용 가능 합니다.");
		}
	});
	
	//phone 유효검사
	$("#phonechk").keyup(function(){
		
		var phone = RegExp(/^\d{3}\d{3,4}\d{4}$/);
		
		if(!phone.test($("#phonechk").val())){
			$("#phonemsg").html("형식에 맞게 입력 해주세요.");
			return false;
		}else{
			$("#phonemsg").html("사용 가능 합니다.");
		}

	});
	
	//회원 가입 등록을 할 경우 유효성 검사 필요
	$("#enter").click(function(){
		
		var password = $("#pw").val(); //password
		var passwordchk = $("#pwchk").val(); //password check
		
		//ID 공백 불가
		if($("#idchk").val() ==""){
			$("#idmsg").html("ID를 입력 해 주세요.");
			return false;
		}
		//Password 공백 불가
		if($("#pw").val() == ""){
			//alert("아이디를 입력 해 주세요");
			//$("#idchk").focus();
			$("#pwmsg").html("Password 입력 해 주세요");
			return false;
		}
		
		//password 유효성 검사
		var pw = $("#pw").val(); 
		var pass= RegExp(/^[a-zA-Z0-9]{4,20}$/);
		
		var password = $("#pw").val();
		var passwordchk = $("#pwchk").val();
		
		if(password == passwordchk){
			$("#pwchkmsg").html("일치합니다.");
		}else{
			$("#pwchkmsg").html("틀렸습니다.다시 입력 해 주세요.");
			$("#pwchkmsg").val("");
		}
		
		if(!pass.test(pw)){
			$("#pwmsg").html("형식에 맞게 입력 해 주세요.");
			return false;
		}else{
			$("#pwmsg").html("사용 가능 합니다.");
		}
		
		
		//password 재입력 시 공백 불가
		if($("#pwchk").val() == ""){
			//alert("아이디를 입력 해 주세요");
			//$("#idchk").focus();
			$("#pwchkmsg").html("Password 재 입력 해 주세요");
			return false;
		}
		
		//password recheck
		if(password != passwordchk){
			$("#pwchkmsg").html("틀렸습니다.다시 입력 해 주세요.");
			//$("#pwchkmsg").val();
			return false
		}
		
		//password check 유효성 검사
		var password = $("#pw").val();
		var passwordchk = $("#pwchk").val();
		
		if(password == passwordchk){
			$("#pwchkmsg").html("일치합니다.");
		}else{
			$("#pwchkmsg").html("틀렸습니다.다시 입력 해 주세요.");
			$("#pwchkmsg").val("");
		}
		
		
		//이름 공백 불가
		if($("#namechk").val() == ""){
			$("#namemsg").html("이름을 입력 해 주세요.");
			//$("#namemsg").val();
			return false
		}
		
		//이름 형식 확인
		var named= RegExp(/^[A-Z가-힣]+$/);
		
		if(!named.test($("#namechk").val())){
			$("#namemsg").html("형식에 맞게 입력 해 주세요.");
			return false;
		}
		
		//연락처 공백 불가
		if($("#phonechk").val() == ""){
			$("#phonemsg").html("연락처를 입력 해 주세요.");
			//$("#phonemsg").val();
			return false;
		}
		
		//연락처 정규식 표현
		var phone = RegExp(/^\d{3}\d{3,4}\d{4}$/);
		
		if(!phone.test($("#phonechk").val())){
			$("#phonemsg").html("형식에 맞게 입력 해주세요.");
			return false;
		}else{
			$("#phonemsg").html("사용 가능 합니다.");
		}
		
		//E-mail 공백 불가
		if($("#email").val() == ""){
			$("#emailchk").html("E-mail을 입력 해 주세요.");
			//$("#emailchk").val();
			return false
		}
		
		//E-mail filter 유효 확인
		var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		
		if(!filter.test($("#email").val())){
			$("#emailchk").html("이메일 주소가 유효하지 않습니다.");
			return false;
		}
		
		//ID 중복 체크를 누르지 않은 경우
		if($("#btn_idchk").val() == "N"){
			$("#idmsg").html("중복 확인 해 주세요");
			return false;
		}
		
	});
	$("#enteracc").click(function(){
		$('form').attr({action:'accModify', method:'post'}).submit();
	});
	