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
            <h1>List Board</h1>
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
              <h3>List Board</h3>
              <hr>
              
              <!-- Search -->
            <form action="../board/boardlist" method="get">  
  			 <div class="input-group mb-4" id="search1">
  			 
  			  <input type="hidden" name="pageNum" value="${page.cri.getPageNum()}">
              <!--<input type="hidden" name="amount" value="${page.cri.getAmount()}">-->
              
     		 	<input type="search" name="keyword" placeholder="What're you searching for?" aria-describedby="button-addon6" class="form-control">
  				 <div class="input-group-append">
     				<button id="button-addon6" type="submit" class="btn btn-info">search</button>
  				</div>
  			</div>
  			</form>
              <label>List Board</label>
              <form action="boardreg" method="GET">
              <table border="1">
              	<tr>
              		<th>NO</th>
              		<th>TITLE</th>
              		<th>DATE</th>	
              		<th>CNT</th>	
              	</tr>
              	<c:forEach items="${list}" var="board" >  
              	<tr>
              		<td>${board.bno}</td>
              		<td><a href='boarddtail?no=${board.bno}&id=${member.userid}'>${board.title}</a></td>
              		<td>${board.write_date}</td>	
              		<td>${board.cnt}</td>	
              	</tr>
              	</c:forEach>
              	<tr>
              		<td colspan="4">
              			<!-- 이전 버튼 -->
              			<c:if test="${page.prev}">
              				<a href="boardlist?pageNum=${page.startPage-1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">Previous</a>
              			</c:if>
              			
              			<!-- 페이징 번호 -->
              			<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
              				<a href="boardlist?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num}</a>
              			</c:forEach>
              			
              			<!-- 다음 버튼 -->
              			<c:if test="${page.next}">
              				<a href="boardlist?pageNum=${page.endPage+1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">Next</a>
              			</c:if>
              		</td>
              	</tr>
              </table>
              <input type="hidden" name="writer" value="${member.userid}">
              <button type="submit" class="btn btn-primary" id="write">Write</button>

            </div>
          </div>
       </form>
      </div>
    </div>
  </div>
</body>
</html>
