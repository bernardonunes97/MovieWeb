<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Esqueci minha senha</title>
</head>
<body>
  <%@ include file="NavBar.jsp" %>
  
  <%
    String error = (String)request.getAttribute("error");
    if (error != null) {  %>
      <div class="alert alert-danger">
        ${error}
      </div>
  <% } %>
  
  <div class="center">
    <h2>Trocar senha</h2>
  </div>

  <div class="center-border">
    <form action="NewPasswordServlet" method="post">
      <div class="margin-top mx-auto w-75 form-group">
        <input type="text" class="form-control" placeholder="NAME" name="name">
      </div>

      <div class="mx-auto w-75 form-group">
        <input type="text" class="form-control" placeholder="USERNAME" name="user">
      </div>

      <div class="mx-auto w-75 form-group">
        <input type="password" class="form-control" placeholder="NEW PASSWORD" name="pwd">
      </div>
      
      <div class="mx-auto w-75 form-group">
        <input type="password" class="form-control" placeholder="REPEAT PASSWORD" name="pwd2">
      </div>
      <div class="margin-top text-center">
        <button type="submit" style="margin-bottom: 8%" class="btn btn-outline-dark">ALTERAR</button>
      </div>
    </form>
  </div>

</body>
</html>
