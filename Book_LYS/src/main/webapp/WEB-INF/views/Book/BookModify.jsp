<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <a class="nav-link" href="#">${member.userid}님 안녕하세요.</a>
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
            <h1>Book Update</h1>
          </div>
        </div>
      </div>
    </div>
  </header>

   <!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
         <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <h3>Book Update</h3>
              <hr>
              <label>Book Update</label>
              <form>
              <table border="1">
				<tr>
					<th>NO</th>
					<td><input type="text" value="${bookmodify.bookno}" name="bookno" readonly></td>
				</tr>
				<tr>
					<th>Book Title</th>
					<td><input type="text" value="${bookmodify.b_title}" name="b_title"></td>
				</tr>
				<tr>
					<th>Book</th>
					<td>
					<img src="../resources${bookmodify.b_thumbnail}"/>
					<input type="hidden" value="${bookmodify.b_img}" name="b_img">
					<input type="hidden" value="${bookmodify.b_thumbnail}" name="b_thumbnail">
					<br>
					<input type="file" name="file" id="b_img">
					<div class="select_img"><img src=""/><%=request.getRealPath("/")%></div>
					</td>
				</tr>
				<tr>
					<th>Price</th>
					<td><input type="text" value="${bookmodify.b_price}" name="b_price"></td>
				</tr>
				<tr>
					<th>Contents</th>
					<td><textarea name="b_contents">${bookmodify.b_contents}</textarea></td>
				</tr>
				<tr>
					<th>Date</th>
					<td><input type="text" value="${bookmodify.b_regdate}" name="b_regdate" readonly></td>
				</tr>              
              </table>
              <br>
              <input type="hidden" value="${member}">
              <button type="submit" class="btn btn-primary" id="modify">Enter</button></a>
            </div>
          </div>
      </div>
      </form>
    </div>
  </div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../resources/JS/Book_upload.js"></script> 
</body>
</html>
