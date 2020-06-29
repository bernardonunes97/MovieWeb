<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <nav class="navbar navbar-inverse bg-dark navbar-dark">

      <div class="col">
        <a class="navbar-brand" href="MovieListView.jsp">iMDB filmes</a>
      </div>
      
      <div class="col-9"></div>

      <div class="col w-100">
		  <a class="navbar-brand" href="NavBar.jsp"><i class="fas fa-star"></i></a>
		  <c:choose>
		  		<c:when test="${username == null }">
		  			<a class="navbar-brand" href="Login.jsp"><i class="fas fa-user-alt"></i> Entrar</a>
		  		</c:when>
		  		<c:otherwise>
		  			<a class="navbar-brand" href="Login.jsp"><i class="fas fa-user-alt"></i> ${username}</a>
		  		</c:otherwise>
		  </c:choose>
      </div>
  </nav>
</body>
</html>
