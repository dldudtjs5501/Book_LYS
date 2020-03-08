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
      
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
         <!-- 세션 값이 없으면 login / join 뜨도록 함  -->
        <c:if test="${member == null}">
          <li class="nav-item">
            <a class="nav-link" href="../member/login">LOGIN</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../member/register">JOIN</a>
          </li>
          </c:if>
          <li class="nav-item">
            <a class="nav-link" href="../member/logout">LOGOUT</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../board/boardlist">${member.userid}님</a>
          </li>
        </ul>
      </div>
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
            <h1>${member.userid}님</h1>
            	<h1>안녕하세요!</h1>
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
            <h3>${member.userid}님 Information</h3>
              <hr>
              <label>Account</label>
   
              <table border="1">
				<tr>
					<td>*ID</td>
					<td><input type="text" value="${member.userid}" readonly></td>
				</tr>
				<tr>
					<td>*PASSWORD</td>
					<td><input type="password" value="${member.password}"></td>
				</tr>
				<tr>
					<td>*NAME</td>
					<td>${member.name}</td>
				</tr>
				<tr>
					<td>*PHONE</td>
					<td>${member.phone}</td>
				</tr>
				<tr>
					<td>*EMAIL</td>
					<td>${member.email}</td>
				</tr>
				<tr>
					<td>POST</td>
					<td>${member.address_post}</td>
				</tr>
				<tr>
					<td>STREET</td>
					<td>${member.address_road}</td>
				</tr>
				<tr>
					<td>AREA</td>
					<td>${member.address_jibun}</td>
				</tr>
				<tr>
					<td>DETAIL</td>
					<td>${member.address_detail}</td>
				</tr>
			</table>
		
			<br>
            <a href='../member/accModify?member=${member.userid}'><button type="submit" class="btn btn-primary" id="enteracc">Update</button></a>
            <a href='../member/memberdel?member=${member.userid}'><button type="submit" class="btn btn-primary">탈퇴</button></a>
        </form>
      </div>
    </div>
  </div>
</body>

</html>
