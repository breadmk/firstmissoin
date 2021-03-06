<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../layout/header.jsp" %>
<script src="/static/js/content.js"></script>  
<div class="container">
  <h2>내용 상세보기</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <td id="no">${dto.no}</td>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th>제목</th>
        <td>${dto.title}</td>
      </tr>
      <tr>
      	<th>내용</th>
      	<td>${dto.content}</td>
      </tr>
      <tr>
      	<th>작성자</th>
      	<td>${dto.name}</td>
      </tr>
      <tr>
      	<th>작성일</th>
    	<fmt:parseDate value="${dto.writedate}" var="writedate" pattern="yyyy-MM-dd"/>
		<td><fmt:formatDate value="${writedate}" pattern="yyyy-MM-dd"/></td>
      </tr>
      <tr>
      	<td colspan="2">
      		<button type="button" class="btn btn-primary list" onclick="list()">목록</button>
      	 <c:if test="${username eq dto.name}">
      		<button type="button" class="btn btn-success update" onclick="update()">수정</button>
      		<button type="button" class="btn btn-danger deleteOk" onclick="deleteOk()">삭제</button>
      	 </c:if>
      	</td>
      </tr>
      <tr>
      	<c:if test="${param.chk!=null}">
      		<td>비밀번호가 틀렸습니다.</td>
      	</c:if>
      </tr>
    </tbody>
  </table>
</div>
<%@ include file="../layout/footer.jsp" %>