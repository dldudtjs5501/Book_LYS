<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Booklys Board</title>
  <link href="resources/CSS/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="resources/CSS/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
  <!-- Navar -->
  <link href="resources/CSS/paper-kit.css?v=2.2.0" rel="stylesheet" />
  <link href="resources/CSS/demo.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="resources/CSS/clean-blog.min.css" rel="stylesheet">
  
  <!-- Search -->
  <link href="resources/CSS/search.css" rel="stylesheet"> 
  
</head>
<!-- CSS 적용 -->
<style>
#r1{
	margin-top:-40px;
	margin-left:600px;
	width:75%;
}
#paging{
	bottom:0px;
	position:fixed;
}

</style>

<body>

  <!-- Navigation -->
 
 <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">   
 
    <div class="container">
      <a class="navbar-brand" href="http://localhost:8080/lys">Book LYS</a>
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
          <li class="nav-item">
          <c:if test="${member.userid == 'admin'}">
           <a class="nav-link" href="Book/bookwrite">관리자(${member.userid})의 Page </a>
          </li>
          </c:if>
        </ul>
      </div>
    </div>
	</nav>
  <!-- Page Header -->
  <header class="masthead" style="background-image: url('resources/IMAGE/book.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>BOOK LYS</h1>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- Navar -->
 <center><div class="row" id="r1">
          <div class="col-md-6">
            <nav class="navbar navbar-expand-lg bg-primary">
              <a class="navbar-brand" href="#">Menu</a>
              <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-bar"></span>
                <span class="navbar-toggler-bar"></span>
                <span class="navbar-toggler-bar"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="navbar-nav mr-auto">
                  <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" id="dropdownMenuButton" href="#pk" role="button" aria-haspopup="true" aria-expanded="false">My Page</a>
                    <ul class="dropdown-menu dropdown-info" aria-labelledby="dropdownMenuButton">
                      <!--<li class="dropdown-header">My Page</li>-->
                      <a id="my" class="dropdown-item" href="OrderList?member=${member.userid}" value="${member.userid}">나의 계정</a> 
                    </ul>
                  </div>
                  <li class="nav-item">
                    <a  id="board" class="nav-link" href="board/boardlist?id=${member.userid}" value="${member.userid}">Board</a>
                  </li>
                   <li class="nav-item">
                    <a id="cart" class="nav-link"  href="Cart/CartList?id=${member.userid}" value="${member.userid}">Cart</a>
                  </li>
                </ul>
              </div>
            </nav>
          </div>
  </center>
 
  <!-- Search -->
  <form action=" " method="get">
  <div class="input-group mb-4" id="search1">
   <input type="hidden" name="pageNum" value="${page.bcri.getB_pageNum()}">
     <input type="search" name="keyword" placeholder="What're you searching for?" aria-describedby="button-addon6" class="form-control">
  <div class="input-group-append">
     <button id="button-addon6" type="submit" class="btn btn-info">search</button>
  </div>
  </div>
  </form>
  <!-- 상품 보여주기 -->
  <div class="container">
    <div class="row">
    <c:forEach items="${list}" var="b_list">
    <div class="col-lg-4 col-sm-6 mb-4">
      <div class="card h-100">
        <a href="mainbookdet?bookno=${b_list.bookno}&member=${member.userid}"><img class="card-img-top" src="resources${b_list.b_thumbnail}" alt=""></a>
        <div class="card-body">
          <h4 class="card-title">${b_list.b_title}</h4>
          <p class="card-text">${b_list.b_contents}</p>
        </div>
      </div>
    </div>
	</c:forEach>
  <!-- /.row -->
  <!-- pagenation -->
            <br>
           <div> 
   		    <div id="paging" class="col-lg-6">
            <div class="bs-component">
              <div>
                <ul class="pagination">
                  <!-- 이전버튼 -->
                  <c:if test="${page.b_prev}">
                  <li class="page-item">
                  <a  class="page-link" href="?b_pageNum=${page.b_startPage-1}&b_amount=${page.bcri.b_amount}&keyword=${page.bcri.keyword}">&laquo;</a>
                  </li>
                  </c:if>
                  <!-- 페이징 번호 -->
                  <c:forEach var="num" begin="${page.b_startPage}" end="${page.b_endPage}">
                  <li class="page-item active">
                  <a class="page-link" href="?b_pageNum=${num}&b_amount=${page.bcri.b_amount}&keyword=${page.bcri.keyword}">${num}</a>
                  </li>
                  </c:forEach>
                  <!-- 다음버튼 -->
                  <c:if test="${page.b_next}">
                  <li class="page-item">
                    <a class="page-link" href="?b_pageNum=${page.b_endPage+1}&b_amount=${page.bcri.b_amount}&keyword=${page.bcri.keyword}">&raquo;</a>
                  </li>
                  </c:if>
                </ul>
              </div>
             </div>
      		</div>
		  </div>      	
<!-- /.container -->
      
<!--   Core JS Files   -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="resources/JS/popper.min.js" type="text/javascript"></script>
<script src="resources/JS/bootstrap.min.js" type="text/javascript"></script>   
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="resources/JS/bootstrap-switch.js"></script>
<script src="resources/JS/book_lys.js"></script>
</body>

</html>
