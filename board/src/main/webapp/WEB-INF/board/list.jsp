<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../layout/header.jsp" %>
<script src="/static/js/list.js"></script>
<div class="container">
  <h2>게시판</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="dto">
      <tr class="contentRow">
        <td id="no">${dto.no}</td>
        <td>${dto.title}</td>
        <td>${dto.name}</td>
        <fmt:parseDate value="${dto.writedate}" var="writedate" pattern="yyyy-MM-dd"/>
		<td><fmt:formatDate value="${writedate}" pattern="yyyy-MM-dd"/></td>
      </tr>
     </c:forEach>
     <tr>
     	<td colspan="1"><button type="button" class="btn btn-dark" id="register">글쓰기</button></td>
     	<td colspan="3">
     		<form method="post" action="list">
		 <select name="searchOption">
			<option value="name">작성자</option>
			<option value="title">제목</option>
		 </select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
     	</td>
     </tr>
    </tbody>
  </table>
</div>
<%@ include file="../layout/footer.jsp" %>