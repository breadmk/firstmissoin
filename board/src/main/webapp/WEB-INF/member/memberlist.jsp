<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
  <h2>회원정보</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>주소</th>
        <th>작성글수</th>
        <th>탈퇴처리</th>
        <th>가입축하메일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="member">
      <tr class="contentRow">
        <td id="no">${member.no}</td>
        <td>${member.userid}</td>
        <td>${member.username}</td>
		<td>${member.email}</td>
		<td>${member.addr}</td>
		<td>${member.count}</td>
		<td><button type="button" class="btn btn-danger deleteOk">탈퇴</button></td>
		<c:if test="${member.state == 1}">
		<td><button type="button" class="btn btn-dark email" disabled="disabled">발송완료</button></td>
      	</c:if>
      	<c:if test="${member.state == 0}">
		<td><button type="button" class="btn btn-info email">발송</button></td>
      	</c:if>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>
<script src="/static/js/member.js"></script>
<%@ include file="../layout/footer.jsp" %>