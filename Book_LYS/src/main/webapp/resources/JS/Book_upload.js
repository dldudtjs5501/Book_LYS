$("#b_img").change(function(){
	if(this.files && this.files[0]){
		var reader = new FileReader;
		reader.onload = function(data){
			$(".select_img img").attr("src",data.target.result).width(200);
		}
		reader.readAsDataURL(this.files[0]);
	}
});

$("#write").click(function(){
	$('form').attr({action:'bookwrite', method:'post',enctype:'multipart/form-data'}).submit();
});

$("#List").click(function(){
	$('form').attr({action:'booklist', method:'get'}).submit();
});

$("#modify").click(function(){
	$('form').attr({action:'bookmodify', method:'post',enctype:'multipart/form-data'}).submit();
});


