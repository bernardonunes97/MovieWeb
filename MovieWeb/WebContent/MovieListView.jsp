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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="script/MovieScript.js"></script>
    </head>
    <body>
    	<header>
  			<%@ include file="NavBar.jsp"%>  	
    	</header>
  
        <div class="row row-cols-1 row-cols-md-5">       
        	<c:forEach var="movie" items="${controller.loadMovies(2)}">
        		  <div class="col mb-5">
	                <div class="card-container"> 
	                    <div class="card card-front bg-dark text-white">
	                        <img src="https://image.tmdb.org/t/p/original${movie.poster}" class="card-img-top">
	                        <div class="card-body">
	                            <p class="card-title"><i class="fas fa-star"></i><b> ${movie.vote}/10</b></p>
	                            <p class="card-text">${movie.title}</p>
	                            <button id="likebtn" class="btn btn-outline-primary" onclick="likeOrDislikeMovie();">Like</button>
	                        </div>
	                    </div>
	                </div>
	            </div>
        	</c:forEach>
        </div>
    </body>
</html>