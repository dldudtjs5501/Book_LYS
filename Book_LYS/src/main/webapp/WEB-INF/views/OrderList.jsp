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

  <title>ORDER LIST</title>
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
.orderOpen{
	float:right;
	margin-right:10px;
}
.orderinfo{
	margin:10px 10px;
	display:none;
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
            <a class="nav-link" href="admin/alogin">ADMIN LOGIN</a>
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
  <header class="masthead" style="background-image: url('resources/IMAGE/buy.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>Order List</h1>
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
              <h3>Order List</h3>
              <hr>
              <label>Order List</label>
              
				<table border="1">
				<c:forEach items="${orderList}" var="orderlist">
					<tr>
						<th colspan="2">주문번호</th>
					</tr>
					<tr>
						<th colspan="2"><a href="orderlistdetail?orderid=${orderlist.orderid}&member=${member.userid}">${orderlist.orderid}</a></th>
					</tr>
					<tr>
						<th>수령인</th>
						<td>${orderlist.orderrec}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${orderlist.o_address_post}/ 
							${orderlist.o_address_road}
							${orderlist.o_address_detail}
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><fmt:formatNumber value="${orderlist.o_amount}" pattern="###,###,###"/>&nbsp;원</td>
					</tr>
				</c:forEach>
				</table>
              <br>
            </div>
         </div>
      </div>
    </div>
  </div>
</body>
</html>