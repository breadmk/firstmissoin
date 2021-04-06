<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
	<form action="/member/loginOk" method="post">
		<div class="form-group">
			<label for="username">UserId</label> 
			<input type="text" class="form-control" placeholder="Enter username" id="userid" name="userid">
		</div>
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="pwd" name="pwd">
			<c:if test="${param.chk!=null}">
			<span>비밀번호 또는 아이디를 확인하세요<span>
			</c:if>
		</div>
		<button id="btn-login" class="btn btn-primary">로그인</button>
	</form>

</div>
<%@ include file="../layout/footer.jsp" %>