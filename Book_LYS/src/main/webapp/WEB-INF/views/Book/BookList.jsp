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
            <h1>Book List</h1>
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
              <h3>Book List</h3>
              <hr>
              <label>Book List</label>
              <form action="bookwrite" method="get">
              <table border="1">
              	<tr>
              		<th>NO</th>
              		<th>IMAGE</th>
              		<th>TITLE</th>
              		<th>PRICE</th>	
              	</tr> 
           		<c:forEach items="${list}" var="b_list">
              	<tr>
              		<td>${b_list.bookno}</td>
              		<td><a href="bookdtail?bookno=${b_list.bookno}"><img src="../resources${b_list.b_thumbnail}"/></a></td>
              		<td>${b_list.b_title}</td>
              		<td>${b_list.b_price}</td>	
              	</tr>
              	</c:forEach>
              </table>
               <!-- pagenation -->
            <br>
   		    <div class="col-lg-6">
            <div class="bs-component">
              <div>
                <ul class="pagination">
                  <!-- 이전버튼 -->
                  <c:if test="${page.b_prev}">
                  <li class="page-item">
                  <a  class="page-link" href="booklist?b_pageNum=${page.b_startPage-1}&b_amount=${page.bcri.b_amount}">&laquo;</a>
                  </li>
                  </c:if>
                  <!-- 페이징 번호 -->
                  <c:forEach var="num" begin="${page.b_startPage}" end="${page.b_endPage}">
                  <li class="page-item active">
                  <a class="page-link" href="booklist?b_pageNum=${num}&b_amount=${page.bcri.b_amount}">${num}</a>
                  </li>
                  </c:forEach>
                  <!-- 다음버튼 -->
                  <c:if test="${page.b_next}">
                  <li class="page-item">
                    <a class="page-link" href="booklist?b_pageNum=${page.b_endPage+1}&b_amount=${page.bcri.b_amount}">&raquo;</a>
                  </li>
                  </c:if>
                </ul>
              </div>
             </div>
      		</div>
              <br>
              <input type="hidden" value="${member}">
              <button type="submit" class="btn btn-primary">Write</button>
            </div>
          </div>
       </form>
      </div>
    </div>
  </div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</body>
</html>
