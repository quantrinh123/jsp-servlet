<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

</head>
<body>

<ul>
<c:forEach items="${key}" var="value">
  <li> ${value} </li>
  </c:forEach>
 </ul>
</body>
</html>