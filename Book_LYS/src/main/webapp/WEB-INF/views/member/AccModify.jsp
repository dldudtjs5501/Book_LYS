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
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="../member/logout">LOGOUT</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../board/boardlist">${member.userid}님</a>
          </li>
        </ul>
      </div>
      </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('../resources/IMAGE/account.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>${member.userid}</h1>
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <form>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
            <h3>${member.userid}님의 계정 수정</h3>
              <hr>
              <label>Member</label>
              <table border="1">
				<tr>
					<td>*ID</td>
					<td>
					<input type="text"  name="userid" id="idchk" value="${member.userid}" readonly>
					</td>
				</tr>
				<tr>
					<td>*PASSWORD</td>
					<td>
					<input type="password" name="password" class="form-control" id="pw" value="${member.password}">
					<span id="pwmsg"></span>
					</td>
				</tr>
				<tr>
					<td>*PASSWORD Check</td>
					<td>
					<input type="password" class="form-control" id="pwchk" placeholder="Password Check">
					<span id="pwchkmsg"></span>
					</td>
				</tr>
				<tr>
					<td>*NAME</td>
					<td>
					<input type="text" name="name" class="form-control" id="namechk" value="${member.name}">
					<span id="namemsg"></span>
					</td>
				</tr>
				<tr>
					<td>*PHONE</td>
					<td>
					<input type="text" name="phone" class="form-control" id="phonechk" value="${member.phone}">
					<span id="phonemsg"></span>
					</td>
				</tr>
				<tr>
					<td>*EMAIL</td>
					<td>
					<input type="text" name="email" id="email" value="${member.email}">
					<span id="emailchk"></span>
					</td>
				</tr>
				<tr>
					<td>POST</td>
					<td>
						<input type="button" value="우편번호 찾기" onclick="Postcode()">
						<input type="text" name="address_post" id="postcode" class="form-control" value="${member.address_post}">
						
					</td>
				</tr>
				<tr>
					<td>STREET</td>
					<td>
					<input type="text" name="address_road" id="road" class="form-control" value="${member.address_road}">
					</td>
				</tr>
				<tr>
					<td>AREA</td>
					<td>
					<input type="text" name="address_jibun" id="jibun" class="form-control" value="${member.address_jibun}">
					</td>
				</tr>
				<tr>
					<td>DETAIL</td>
					<td>
					<input type="text" name="address_detail" class="form-control" value="${member.address_detail}">
					</td>
				</tr>
			</table>
			<br>
            <button type="button" class="btn btn-primary" id="enter" value="">Enter</button>
            <button type="reset" class="btn btn-primary">Cancel</button>
          	
          	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>  
			<script type="text/javascript" src="../resources/JS/Daumpostcode.js"></script>
			<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<!--<script type="text/javascript" src="../resources/JS/AccountCheck.js"></script>-->
			<script type="text/javascript" src="../resources/JS/membercheck.js"></script>
        </form>
      </div>
    </div>
  </div>
  <hr>

</body>
</html>
