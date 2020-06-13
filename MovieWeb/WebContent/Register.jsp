<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%@ include file="NavBar.jsp" %>
  <div class="center">
    <h2>Cadastrar</h2>
  </div>

  <div class="center-border">
    <form action="">
      <div class="margin-top mx-auto w-75 form-group">
        <input type="text" class="form-control" placeholder="NAME" id="name">
      </div>

      <div class="mx-auto w-75 form-group">
        <input type="text" class="form-control" placeholder="USERNAME" id="user">
      </div>

      <div class="mx-auto w-75 form-group">
        <input type="password" class="form-control" placeholder="PASSWORD" id="pwd">
      </div>
      <div class="margin-top text-center">
        <button type="submit" style="margin-bottom: 8%" class="btn btn-outline-dark">CADASTRAR</button>
      </div>
    </form>
  </div>

</body>
</html>
