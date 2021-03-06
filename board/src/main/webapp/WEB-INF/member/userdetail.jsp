<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
  <h2>사용자 상세 정보</h2>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>UserId</th>
        <td colspan="2" id="userid">${dto.userid}</td>
      </tr>
       <tr>
        <th>Username</th>
        <td colspan="2">${dto.username}</td>
      </tr>
       <tr>
        <th>Email</th>
        <td colspan="2">${dto.email}${pwdOk}</td>
      </tr>
      	<tr>
        <th>기존비밀번호</th>
        <td><input type="password" class="form-control" id="pwd" name="pwd"></td>
      	<td><button id="chk">비밀번호확인</button></td>
      </tr>
      <tr>
      	<th>변경할 비밀번호</th>
      	<td><input type="password" class="form-control" id="pwd2" name="pwd"></td>
      	<td><button id="chk2">비밀번호변경</button></td>
      </tr>
    </thead>
  </table>
</div>
<script src="/static/js/userdetail.js"></script>
<%@ include file="../layout/footer.jsp" %>