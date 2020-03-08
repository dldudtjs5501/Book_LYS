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
.allcheck{
	width:100px;
}
.delBtn{
	float:right;
	margin-top:-20px;
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
            <a class="nav-link" href="../member/login">LOGIN</a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="../admin/alogin">ADMIN LOGIN</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../member/register">JOIN</a>
          </li>
          </c:if>
           <!-- 세션 값이 있을 경우 id의 값이 뜨도록 지정 함 -->
          <c:if test="${member != null}">
          <li class="nav-item">
            <a class="nav-link" href="../member/logout">LOGOUT</a>
          </li>
          <li class="nav-item">
          <a class="nav-link" href="../member/account?member=${member.userid}">${member.userid}님 안녕하세요!</a>
          </li>
          </c:if> 
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('../resources/IMAGE/cart.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>Cart List</h1>
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
              <h3>Cart List</h3>
              <hr>
              <c:choose>
				<c:when test="${map.count == 0}">
				<h3>Cart가 비어 있습니다.</h3>
				<br>
				<a href="http://localhost:8080/lys/"><h3>MAIN</h3></a>
			  </c:when>
			  <c:otherwise>
              <form id="countupdate">
              <table border="1">
				<tr>
					<th>NO</th>
					<th>TITLE</th>
					<th>BOOK</th>
					<th>PRICE</th>
					<th>SUM</th>
					<th>COUNT</th>
					<th>CANSEL/UPDATE</th>
				</tr>
				<c:set var="sum" value="0" />
				<c:forEach var="cart" items="${map.list}">
				<tr>
					<td>${cart.cart_id}</td>
					<td>${cart.b_title}</td>
					<td><img src="../resources${cart.b_thumbnail}"/></td>
					<td><fmt:formatNumber value="${cart.b_price}" pattern="###,###,###"/>&nbsp;원</td>
					<td><fmt:formatNumber value="${cart.money}" pattern="###,###,###"/>&nbsp;원</td>
					<td>
						<select name="amount${cart.bookno}">
							<option value="${cart.amount}" hidden>${cart.amount}</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>&nbsp;개
					</td>
					
					<td>
					<input type="hidden" name=cart_id value="${cart.cart_id}">
					<input type="hidden" name=bookno value="${cart.bookno}" id="bookno">
					<input type="hidden" name=writer id="writer" value="${member.userid}">	
					<a href="CartDel?cart_id=${cart.cart_id}">CANCEL</a>
					<br>
					<br>
					<button onclick="countupdate(${cart.bookno})">UPDATE</button>
					<br>
					<br>
					</td>
				</tr>
				<c:set var="sum" value="${sum+(cart.b_price*cart.amount)}"/>
				</c:forEach>
				<tr>
					<td colspan="7">
						<br>
						Cart 금액 합계 : <fmt:formatNumber value="${map.sumMoney}" pattern="###,###,###"/>&nbsp;원<br><br>
						배송료 : <fmt:formatNumber value="${map.delivery}" pattern="###,###,###"/>&nbsp;원<br><br>
						전체 주문 금액 : <fmt:formatNumber value="${map.allSum}" pattern="###,###,###"/> &nbsp;원
						<br>
						 </form>
						<div class="listResult">
						<hr>
							<div class="sum">
								총 합계 : <fmt:formatNumber value="${sum}" />원
							</div>
							<div class="orderOpen">
								<button type="button" class="orderOpen_bnt">주문 정보 입력</button>
							</div>
						</div>
						<br>
						<br>
						<form action="../order" method="post">
						<div class="orderinfo">
							<input type="hidden" name=writer id="writer" value="${member.userid}">	
							<input type="hidden" name="o_amount" value="${sum}"/>
							<table border="1">
								<tr>
									<td><input type="text" name="ordersend" placeholder="주문 한 분" required></td>
								</tr>
								<tr>
									<td><input type="text" name="o_phone" placeholder="주문 한 분 연락처" required></td>
								</tr>
								<tr>
									<td><input type="text" name="orderrec" placeholder="수령인" required></td>
								</tr>
								<tr>
									<td><input type="text" name="r_phone" placeholder="수령인 연락처" required></td>
								</tr>
								<tr>
									<td>
										<input type="button" value="우편번호 찾기" onclick="Postcode()">
										<input type="text" name="o_address_post" id="postcode" placeholder="우편번호" class="form-control" required>
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" name="o_address_road" id="road" placeholder="도로명주소" class="form-control" required>
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" name="o_address_detail" id="jibun" placeholder="지번주소" class="form-control" required>
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" name="place" placeholder="부재 시 위탁 할 장소" class="form-control" required>
									</td>
								</tr>
								<tr>
									<td>
										<p>결제 방법</p>
										<input type="radio" name="pay" value="무통장 입금" required>무통장 입금
										<input type="radio" name="pay" value="계좌이체" required>계좌이체
										<input type="radio" name="pay" value="신용카드" required>신용카드
										<input type="radio" name="pay" value="휴대폰 결제" required>휴대폰 결제
									</td>
								</tr>
							</table>
							<br>
            				<button type="button" class="btn btn-primary" id="cancel_btn">CANCEL</button>
						</div>
					</td>
				</tr>
              </table>
              <br>
              <button type="submit" class="btn btn-primary">BUY</button>
              </form>
              <button type="submit" class="btn btn-primary" id="main">MAIN</button>
            </div>
            </c:otherwise>
            </c:choose>
          </div>
      </div>
    </div>
  </div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>  
<script type="text/javascript" src="../resources/JS/Daumpostcode.js"></script>
<script type="text/javascript" src="../resources/JS/payment.js"></script>


</body>
</html>