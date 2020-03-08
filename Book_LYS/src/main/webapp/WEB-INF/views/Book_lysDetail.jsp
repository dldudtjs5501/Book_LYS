<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Booklys Detail</title>
<link href="resources/CSS/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="resources/CSS/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="resources/CSS/clean-blog.min.css" rel="stylesheet">
</head>
<body>

<style>
textarea{
	width:100%;
	height:50%;
}
</style>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="http://localhost:8080/lys/">Book LYS</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <c:if test="${member == null}">
          <li class="nav-item">
            <a class="nav-link" href="member/login">LOGIN</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="member/register">JOIN</a>
          </li>
          </c:if>
           <!-- 세션 값이 있을 경우 id의 값이 뜨도록 지정 함 -->
          <c:if test="${member != null}">
          <li class="nav-item">
            <a class="nav-link" href="member/logout">LOGOUT</a>
          </li>
          <li class="nav-item">
          <a class="nav-link" href="member/account?member=${member.userid}">${member.userid}님 안녕하세요!</a>
          </li>
          </c:if> 
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('resources/IMAGE/bookdetail.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>Booklys Detail</h1>
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
              <h3>Booklys Detail</h3>
              <hr>
              <label>Booklys Detail</label>
              <table border="1">
				<tr>
					<th>NO</th>
					<td><input type="text" value="${bookno.bookno}" name="bookmodify" readonly></td>
				</tr>
				<tr>
					<th>Book Title</th>
					<td>${bookno.b_title}</td>
				</tr>
				<tr>
					<th>Book</th>
					<td><img src="resources${bookno.b_thumbnail}"/>
					<input type="hidden" value="${bookno.b_img}">
					<input type="hidden" value="${bookno.b_thumbnail}">
					</td>
				</tr>
				<tr>
					<th>Contents</th>
					<td><textarea readonly>${bookno.b_contents}</textarea></td>
				</tr>   
				<tr>
					<th>Price</th>
					<td><fmt:formatNumber value="${bookno.b_price}" pattern="###,###,###"/>&nbsp;원</td>
				</tr>
				<form id="payform">
				<tr>
					<th>Count</th>
					<td>
					<input type="hidden" name="bookno" value="${bookno.bookno}">
					<select name="amount">
					<c:forEach begin="1" end="10" var="i">
						<option value="${i}">${i}</option>
					</c:forEach>
					</select>
					&nbsp;개
					</td>
				</tr>
              </table>
              <br>
              <button type="submit" class="btn btn-primary" id="cart">CART</button>
              </form>
            </div>
          </div>
          <br>
          <h3>Review</h3>
          <form name="insertform">
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>Contents</label>
              <textarea placeholder="contents" name="r_contents" id="r_contents" required></textarea>
              <!--<span id="result"> </span>-->
            </div>
          </div>
           <br>
           <input type="hidden" value="${bookno.bookno}" name="bookno" id="bookno">
           <input type="hidden" value="${member.userid}" name="r_writer" id="userid">
           <button type="button" class="btn btn-primary" id="write">Write</button>
           </form>
            <div class="control-group">
            <div class="form-group floating-label-form-group controls">
           <!--<label>ReviewList</label>-->
            <div class="ReviewList"></div>
          	<a href="mainbookdet?bookno=${bookno.bookno}"><button class="btn btn-primary">List</button></a>
          	</div>
          	</div>
      </div>
    </div>
  </div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/JS/review.js"></script>
<script type="text/javascript" src="resources/JS/payment.js"></script>
</body>
</html>