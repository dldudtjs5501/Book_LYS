<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Booklys Board</title>
<link href="../resources/CSS/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="../resources/CSS/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="../resources/CSS/clean-blog.min.css" rel="stylesheet">
</head>
<body>
<!-- css적용 -->
<style>
#btn_idchk{
	margin-top:10px;
}
span{
	color:red;
}
</style>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="../">Book LYS</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('../resources/IMAGE/sign up.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>Sign Up</h1>
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <form action="register" method="post">
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
            <h3>Member</h3>
              <hr>
              <label>Member</label>
              <table border="1">
				<tr>
					<td>*ID</td>
					<td>
					<input type="text"  name="userid" id="idchk" placeholder="ID" required>
					<button type="button" id="btn_idchk" class="btn btn-primary" value="N">check</button>
					<br>
					<span id="idmsg">대,소문자 가능 하며 5자이상 20자이하만 가능 합니다.(!@#$%^&*()_+\?>등,사용불가)</span>
					</td>
				</tr>
				<tr>
					<td>*PASSWORD</td>
					<td>
					<input type="password" name="password" placeholder="PASSWORD" class="form-control" id="pw" required>
					<span id="pwmsg">대,소문자 가능 하며 4자이상 20자이하만 가능 합니다.(!@#$%^&*()_+\?>등,사용불가)</span>
					</td>
				</tr>
				<tr>
					<td>*PASSWORD Check</td>
					<td>
					<input type="password" placeholder="PASSWORD CHECK" class="form-control" id="pwchk"required>
					<span id="pwchkmsg"></span>
					</td>
				</tr>
				<tr>
					<td>*NAME</td>
					<td><input type="text" name="name" class="form-control" id="namechk" placeholder="NAME" required>
					<span id="namemsg"></span>
					</td>
					
				</tr>
				<tr>
					<td>*PHONE</td>
					<td>
					<input type="text" name="phone" class="form-control" id="phonechk" placeholder="PHONE" required>
					<span id="phonemsg"></span>
					</td>
				</tr>
				<tr>
					<td>*EMAIL</td>
					<td>
					<input type="text" name="email" id="email" placeholder="EMAIL" required>
					<span id="emailchk"></span>
					</td>
				</tr>
				<tr>
					<td>POST</td>
					<td>
						<input type="button" value="우편번호 찾기" onclick="Postcode()">
						<input type="text" name="address_post" id="postcode" placeholder="우편번호" class="form-control">
						
					</td>
				</tr>
				<tr>
					<td>STREET</td>
					<td>
					<input type="text" name="address_road" id="road" placeholder="도로명주소" class="form-control">
					</td>
				</tr>
				<tr>
					<td>AREA</td>
					<td>
					<input type="text" name="address_jibun" id="jibun" placeholder="지번주소" class="form-control">
					</td>
				</tr>
				<tr>
					<td>DETAIL</td>
					<td>
					<input type="text" name="address_detail" placeholder="상세 주소" class="form-control">
					</td>
				</tr>
			</table>
			<br>
            <button type="submit" class="btn btn-primary" id="enter">Enter</button>
            <a href="register"><button type="reset" class="btn btn-primary">Cancel</button></a>
          	</form>
      </div>
    </div>
  </div>
  <hr>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>  
  <script type="text/javascript" src="../resources/JS/Daumpostcode.js"></script>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="../resources/JS/membercheck.js"></script>
  <script type="text/javascript" src="../resources/JS/memberfinalchk.js"></script>
</body>
</html>
