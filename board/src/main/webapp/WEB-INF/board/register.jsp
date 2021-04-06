<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
</head>
<body>
<div class="container">
  <h2>게시글 등록하기</h2>
  <form action="/board/registerOk" method="post">
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    <div class="form-group">
	  <label for="content">내용</label>
	  <textarea class="form-control summernote" rows="5" id="content" name="content" placeholder="Enter content"></textarea>
	</div>
    <div class="form-group">
      <label for="name">작성자</label>
      <input type="text" class="form-control" id="name" readonly="readonly" name="name" value="${username}">
      <label for="name">비밀번호</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <button type="submit" class="btn btn-primary">글작성</button>
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