<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="controller" class="br.com.movie.controller.MovieController"/>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
      <link rel="stylesheet" href="css/listMovieStyle.css">
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
      <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="scripts/MovieScript.js"></script>
   </head>
   <body>
      <header>
         <nav class="navbar navbar-inverse bg-light navbar-light">
            <div class="col">
               <a class="navbar-brand" href="#">iMDB filmes</a>
            </div>
            <div class="col-9">
               <input id="txtSearch" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            </div>
            <div class="col">
               <a class="navbar-brand" href="#"><i class="fas fa-star"></i></a>
               <a class="navbar-brand" href="Login.jsp"><i class="fas fa-user-alt"></i> Entrar</a>
            </div>
         </nav>
      </header>
      <div class="row row-cols-1 row-cols-md-5">
         <c:forEach var="movie" items="${controller.loadMovies(actualPage)}">
            <div class="col mb-5">
               <div class="card-container">
                  <div class="card card-front bg-dark text-white">
                     <img src="https://image.tmdb.org/t/p/original${movie.poster}" class="card-img-top">
                     <div class="card-body">
                        <p class="card-title"><i class="fas fa-star"></i><b> ${movie.vote}/10</b></p>
                        <p class="card-text">${movie.title}</p>
                        <c:choose>
                        	<c:when test="${movie.isFavorite}">
                        		<input type="button" class="btn btn-danger" onclick="likeOrDislikeMovie(${movie.id}, ${movie.isFavorite});" value="Dislike">
                        	</c:when>
                        	<c:otherwise>
                        		<input type="button" class="btn btn-outline-primary" onclick="likeOrDislikeMovie(${movie.id}, ${movie.isFavorite});" value="Like">
                        	</c:otherwise>
                        </c:choose>
                     </div>
                  </div>
               </div>
            </div>
         </c:forEach>
      </div>
      <form action="movie">
         <ul class="pagination pagination-justify-center">
            <li class="page-item">
               <button class="page-link" aria-label="Previous"  name="actualPage" value="${actualPage - 1}">
               <span aria-hidden="true">&laquo;</span>
               <span class="sr-only">Previous</span>
               </button>
            </li>
            <c:forEach var="index"  begin="1" end="${controller.numberPages}">
               <c:choose>
                  <c:when test="${index == actualPage}">
                     <li class="page-item active">
                        <input class="page-link" type="submit" name="actualPage" value="${index}">
                     </li>
                  </c:when>
                  <c:otherwise>
                     <li class="page-item">
                        <input class="page-link" type="submit" name="actualPage" value="${index}">
                     </li>
                  </c:otherwise>
               </c:choose>
            </c:forEach>
            <li class="page-item">
               <button class="page-link" aria-label="Next" name="actualPage" value="${actualPage + 1}">
               <span aria-hidden="true">&raquo;</span>
               <span class="sr-only">Next</span>
               </button>
            </li>
         </ul>
      </form>
   </body>
</html>