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
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="../layout/footer.jsp" %>