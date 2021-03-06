<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<div class="container">
	<form method="post">
		<div class="form-group">
			<label for="username">UserId</label> 
			<input type="text" class="form-control" placeholder="Enter username" id="userid" name="userid">
		</div>
		<div class="form-group">
			<label for="username">Username</label> 
			<input type="text" class="form-control" placeholder="Enter username" id="username" name="username">
		</div>
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password" name="pwd">
		</div>
		<div class="form-group">
			<label for="password">Password check</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group">
			<label for="email">Email</label> 
			<input type="text" class="form-control" placeholder="Enter email" id="email" name="email">
		</div>
		<div>
		<input class="form-control" style="width: 40%; display: inline;" placeholder="우편번호" name="zipcode" id="addr1" type="text" readonly="readonly" >
    	<button type="button" class="btn btn-info" id="searAddrBtn">주소검색</button></h3>                          
		</div>
		<div class="field">
    	<input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="addr" id="addr2" type="text" readonly="readonly" />
		</div>
		<div class="field">
	    <input class="form-control" placeholder="상세주소" name="addr_detail" id="addr_detail" type="text"  />
		</div>
	</form>
		<br>
		<button id="join" class="btn btn-primary">회원가입완료</button>
</div>
<script src="/static/js/joinOk.js"></script>
<%@ include file="../layout/footer.jsp" %>