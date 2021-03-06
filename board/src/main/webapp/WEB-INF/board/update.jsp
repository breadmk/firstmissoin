<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
  <h2>게시글 등록하기</h2>
  <form action="/board/updateOk" method="post">
  	<input type="hidden" value="${dto.no}" name="no">
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value="${dto.title}">
    </div>
    <div class="form-group">
	  <label for="content">내용</label>
	  <textarea class="form-control summernote" rows="5" id="content" name="content" placeholder="Enter content">${dto.content}</textarea>
	</div>
    <div class="form-group">
      <label for="name">작성자</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" readonly="readonly" name="name" value="${dto.name}">
      <label for="pwd">비밀번호</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
      <c:if test="${param.chk!=null}">
      <span>비밀번호가 틀립니다.</span>
      </c:if>
    </div>
    <button type="submit" class="btn btn-primary">수정</button>
  </form>
</div>
<script>
      $('.summernote').summernote({
        placeholder: 'Hello Mk',
        tabsize: 2,
        height: 300
      });
</script>
<%@ include file="../layout/footer.jsp" %>