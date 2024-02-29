<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="img1.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<title>Home</title>
<style>
body {
            display: flex;
            min-height: 100vh;
            flex-direction: column;
        }

        .main {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: center; 
            min-height: 100%;
            margin-left:200px;	
            margin-right:200px;
        }
    .card {
            display: flex;
            flex-direction: column;
            padding: 20px;
            width: calc(33.33% - 20px);
            margin: 10px;
            box-sizing: border-box;
}
.log{
	border: 1px solid green;
	margin-left: 10px;
	border-radius:0.1rem ;
	
}
 .log{
	border: 1px solid green;
	margin-left: 10px;
	border-radius:7px ;
}
.log a{
color:green;
margin:10px;
padding:0px;
text-decoration: none;
}
.log a:hover{
background-color:green;
color:white;}
</style>
</head>
<body>
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="homeservlet">
    <img src="https://getbootstrap.com/docs/4.6/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
    Bootstrap
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
        
    </ul>
    <div style="margin-right:10px;">  
    <a class="btn btn-success btn-sm ml-3" href="cartcontroller">
          <i class='bx bxs-cart'></i> Cart
      </a>
      </div>
    <form class="form-inline my-2 my-lg-0" action="SearchController" method="post">
      <input value="${keys}" name="key" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
  <c:if test="${sessionScope.acc != null }">
        <li class="log">
            <a class="LogOut" href="LogOutControler">LogOut</a>
        </li>
    </c:if>
  <c:if test="${sessionScope.acc == null }">
        <li class="log">
            <a class="LogOut" href="Login.jsp">Login</a>
        </li>
    </c:if>
</nav>
</header>
  <c:forEach items="${products}" var="pro">
<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">${pro.getName()}</h5>
    <p class="card-text">${pro.getDcri()}</p>
    <a href="#" class="btn btn-primary">${pro.getPrice()}</a>
  </div>
</div>
</c:forEach>
</body>
</html>