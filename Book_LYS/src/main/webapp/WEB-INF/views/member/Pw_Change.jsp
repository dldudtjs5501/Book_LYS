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
<%@ include file="ID_PWfindNav.jsp"%>
<%@ include file="ID_PWfindHeader.jsp"%>
  <!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
          <%@ include file="IdFind.jsp"%>
          <div class="control-group">
          <div class="form-group floating-label-form-group controls">
          <h3>Password Update</h3>  
         	 <label>Password Update</label>
         	 <form action="pass_change" method="post">
             <input type="password" class="form-control" placeholder="Password" name="password" id="pw" required>
             <input type="password" class="form-control" placeholder="Password Recheck" name="passwordchk" id="pwchk" required>
             <span id="pwchkmsg"> </span>
             <input type="hidden" name="email" value="${email}">
             <br>
            <button type="submit" class="btn btn-primary" id="pwupdate">Enter</button>
            <button type="reset" class="btn btn-primary" >Cancel</button>
            </form>
            </div>
          </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="../resources/JS/idfind.js"></script>
        <script type="text/javascript" src="../resources/JS/membercheck.js"></script>
      </div>
    </div>
  </div>
</body>
</html>
