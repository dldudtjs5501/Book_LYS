
$("#cart").click(function(){
	//alert("cart입니다.");
	$("#payform").attr({action:'Cart/Cartinsert', method:'post'}).submit();
});

$("#main").click(function(){
	$("#countupdate").attr({action:'../', method:'get'}).submit();
});

$(".orderOpen_bnt").click(function(){
	$(".orderinfo").slideDown();
	$(".orderOpen_bnt").slideUp();
});

$("#cancel_btn").click(function(){
	$(".orderinfo").slideUp();
	$(".orderOpen_bnt").slideDown();
});

function countupdate(bookno){
	
	//alert("bookno : "+bookno);
	//alert("selectno : "+$('select[name=amount]').val());
	//alert("selectno : "+$('select[name=amount]').val());	
	
	//$("#cartupdate").attr({action:'Cartupdate',method:'post'}).submit();
	//alert("selectno : "+$('select[name=amount'+bookno+']').val());
	//var selectno = $('select[name=amount'+bookno+']').val();
	
	var cartmodify = {"bookno" :bookno,"amount":$('select[name=amount'+bookno+']').val()};
	
	$.ajax({
		
		url : "Cartupdate",
		type : "post",
		data : cartmodify,
		dataType : "json",
		async : false,
		success : function(data){
			//alert("data : "+data);
			if(data == 1){
				alert("수정 완료 되었습니다.");
				$(location).attr('href','CartList');
			}
		}
		
	});
}


