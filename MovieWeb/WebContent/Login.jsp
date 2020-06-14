<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
  <%@ include file="NavBar.jsp" %>
  <div class="center">
    <h2>Login</h2>
  </div>

  <div class="center-border">
    <form action="LoginServlet" method="post">
      <div class="margin-top mx-auto w-75 form-group">
        <input type="text" class="form-control" placeholder="USERNAME" id="user">
      </div>

      <div class="mx-auto w-75 form-group">
        <input type="password" class="form-control" placeholder="PASSWORD" id="pwd">
      </div>

      <div class="margin-top text-center">
        <button type="submit" style="margin-bottom:2%" class="btn btn-outline-dark">ENTRAR</button>
      </div>

      <div class="text-center" style="margin-bottom:7%">
        <a href="Register.jsp" style="font-size:12px">Cadastrar novo usuário</a>
      </div>

    </form>
  </div>

</body>
</html>
