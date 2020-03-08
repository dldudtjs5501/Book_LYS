
	var bookno = $('#bookno').val(); //게시글 번호
	//var r_contents = $('#r_contents').val(); //댓글 정보
	var r_contents = $('#r_contents').val();
		
	$("#write").click(function(){
		var insertData = $('form[name=insertform]').serialize();
		//alert("insertData : "+insertData);
		commentInsert(insertData);
	});
	
	function commentList(){
		//댓글 목록
		$.ajax({
				url : "Review/reviewlist",
				data : {"bookno" : bookno},
				type : "get",
				async: false, //중복 호출로 인한 에러 방지
				success : function(data){
					var a = '';
					var userid = $("#userid").val(); //세션 id 값
					//alert("userid"+userid);
					
					$.each(data , function(key , value){
						a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
		                a += '<div class="commentInfo'+value.rno+'">'+'댓글번호 : '+value.rno+' / 작성자 : '+value.r_writer;
		                a += '<input type="hidden" id="r_writer" value="'+value.r_writer+'">'
		              //비회원일 경우  수정 안되며, 일반 회원 일 경우 자신의 글만 수정 되며, admin인 경우 수정 다 가능 하도록 조건 
		                if(userid!="" && userid==value.r_writer || userid=='admin'){
		                	a += '<button onclick="commentmodify('+value.rno+',\''+value.r_contents+'\');">수정</button>'
		                }
		              //비회원일 경우  수정 안되며, 일반 회원 일 경우 자신의 글만 수정 되며, admin인 경우 수정 다 가능 하도록 조건 
		                if(userid!="" && userid==value.r_writer || userid=='admin'){
		                	a += '<button onclick="commentDelete('+value.rno+');"> 삭제 </button></div>';
		                }
		                a += '<div class="commentContent'+value.rno+'"> <p> 내용 : '+value.r_contents +'</p> </div>';
		                a += '</div>';
					});
						//alert(a);
						$(".ReviewList").html(a);
						
				}
				
		});
	}
	
	function commentmodify(rno,r_contents){
		//수정화면이 현 위치의 input에 설정
		var a ='';
		
		var userid = $("#userid").val(); //세션 id 값
		//alert("userid"+userid);
		
		var r_writer = $("#r_writer").val(); //게시물 작성 한 id 값
		//alert("r_writer : "+ r_writer);
		
		//비회원일 경우  수정 안되며, 일반 회원 일 경우 자신의 글만 수정 되며, admin인 경우 수정 다 가능 하도록 조건
		if(userid != " " && r_writer==userid || userid=='admin'){
		    a += '<div class="input-group">';
		    a += '<input type="text" class="form-control" name="r_contents_'+rno+'" value="'+r_contents+'"/>';
		    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+rno+');">수정</button> </span>';
		    a += '</div>';
		    //alert("commentmodify : "+a);
		}
		$('.commentContent'+rno).html(a);
	}
	
	function commentUpdateProc(rno){
		//수정 처리
		//alert("update.............");
		var updateContent = $('input[name=r_contents_'+rno+']').val();
		
		//alert(updateContent);
		    
		    $.ajax({
		        url : "Review/reviewmodify",
		        data : {"r_content" : updateContent, "rno" : rno},
		        type : "post",
		        async: false,
		        dataType : "json",
		        success : function(data){
		        	//alert("data : "+data);
		            if(data == 1){ 
		            	commentList(bookno); //댓글 수정후 목록 출력
		            }
		        }
		    });
	}
	
	function commentInsert(insertData){
			//댓글 등록
			$.ajax({
					url : "Review/reviewinsert",
					data : insertData,
					type : "post",
					async: false, //중복 호출로 인한 에러 방지
					dataType:"json",
					success : function(data){
						
						if(data == 1){
							alert("댓글 등록이 완료 되었습니다.");
							commentList();
							$("#r_contents").val("");
						}
						else{
							alert("댓글을 다시 입력 해 주세요");
							location.reload();
						}
						
					},
					error : function(request,status,error){
						//error 확인
						//alert("code = "+ request.status + " message = " +
								///request.responseText + " error = " + error);
						alert("댓글 다시 입력 하세요.");
					}
					
			});
	}
	function commentDelete(rno){
		//alert("delete.......");
		
		$.ajax({
	        url : "Review/reviewdel"+rno,
	        type : 'post',
	        success : function(data){
	        	//alert("data : "+data);
	            if(data == 1) {
	            	commentList(bookno); //댓글 삭제후 목록 출력 
	            }
	        }
	    });
	}
	
	$(document).ready(function(){
	    commentList(); //페이지 로딩시 댓글 목록 출력 
	});