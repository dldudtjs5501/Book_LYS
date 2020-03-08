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
<style>
#List{
	margin-top:16px;
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
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="../member/logout">LOGOUT</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">${member}님 안녕하세요.</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('../resources/IMAGE/admin.png')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>Book Register</h1>
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
            <h3>Book Register</h3>
              <hr>
              <label>Book Title</label>
              <input type="text" placeholder="Book Title" name="b_title">
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>Book price</label>
              <input type="text" class="form-control" placeholder="Book Price" name="b_price">
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>Book Contents</label>
              <textarea placeholder="Book Contents" name="b_contents"></textarea>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>Book IMAGE</label>
              <!-- file의 name값과 VO의 변수와 같으면 시스템에서 혼동으로 인해 적용 안됨. name값과 id 값도 같으면 안됨.-->
              <!-- multipartfile의 변수명과 name명이 같아야 함. -->
              <p>Book IMAGE :</p><input type="file" name="file" id="b_img">
              <div class="select_img">
              	<img src=""/>
            	<!-- 이미지 업로드 되는 위치  -->
            	<%--<%=request.getRealPath("/")--%>
              </div>
             </div>
          </div>
          <div class="control-group">
          <input type="hidden" value="${member}">
          <button type="submit" class="btn btn-primary" id="write">Write</button>
          <button type="submit" class="btn btn-primary" id="List">List</button>
         </div>   
    </div>
    </form>
  </div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../resources/JS/Book_upload.js"></script> 
</body>
</html>
