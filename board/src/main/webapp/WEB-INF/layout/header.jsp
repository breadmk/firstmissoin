<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Mk</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
  
  
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <c:if test="${userid!=null}">
  <a class="navbar-brand" href="/list">Mk</a>
  </c:if>
  <c:if test="${userid==null}">
  <a class="navbar-brand" href="/member/login">Mk</a>
  </c:if>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
  	<c:choose>
  		<c:when test="${userid==null}">
		<ul class="navbar-nav">
	      <li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>
	      <li class="nav-item"><a class="nav-link" href="/member/join">회원가입</a></li>
    	</ul>
    	</c:when>
    	<c:otherwise>
		<ul class="navbar-nav">
			<c:if test="${userid eq 'admin'}">
			<li class="nav-item"><a class="nav-link" href="/member/admin">관리자페이지</a></li>
			</c:if>
		  <li class="nav-item"><a class="nav-link" href="/board/register">글쓰기</a></li>
	      <li class="nav-item"><a class="nav-link" href="/member/userdetail">회원정보</a></li>
	      <li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
	    </ul>
		</c:otherwise>
	</c:choose>
  </div>  
</nav>
<br>