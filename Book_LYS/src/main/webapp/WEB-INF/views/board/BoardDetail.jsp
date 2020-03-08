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
          <c:if test="${member == null}">
          <li class="nav-item">
            <a class="nav-link" href="../member/login">LOGIN</a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="../member/register">JOIN</a>
          </li>
          </c:if>
          <!-- 세션 값이 존재 하면 logout 적용  -->
          <c:if test="${member != null}"> 
          <li class="nav-item">
            <a class="nav-link" href="../member/logout">LOGOUT</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../board/boardlist">${member.userid}님 Board</a>
          </li>
          </c:if>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('../resources/IMAGE/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>Detailed Board</h1>
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
              <h3>Detailed Board</h3>
              <hr>
              <label>FAQ Detail</label>
              <table border="1">
				<tr>
					<th>NO</th>
					<td><input type="text" value="${bno.bno}" name="modify" readonly></td>
				</tr>
				<tr>
					<th>WRITE_DATE</th>
					<td>${bno.write_date}</td>
				</tr>
				<tr>
					<th>WRITER</th>
					<td>${bno.writer}</td>
				</tr>
				<tr>
					<th>TITLE</th>
					<td>${bno.title}</td>
				</tr>
				<tr>
					<th>CONTENTS</th>
					<td><textarea readonly>${bno.contents}</textarea></td>
				</tr>
				<tr>
					<th>CNT</th>
					<td>${bno.cnt}</td>
				</tr>              
              </table>
               <br> 
            <c:if test="${bno.writer==member.userid||member.userid=='admin'}">   
            <a href='boardmodify?modify=${bno.bno}&id=${member.userid}'><button type="submit" class="btn btn-primary">Update</button></a>
            <a href='boarddel?bno=${bno.bno}'><button type="submit" class="btn btn-primary">Delete</button></a>
          	</c:if>
          	<c:if test="${bno.writer!=member.userid && member.userid!='admin'}">
          	<a href='boardlist'><button type="submit" class="btn btn-primary">List</button></a>
          	</c:if>
            </div>
          </div>
      </div>
    </div>
  </div>
</body>
</html>
