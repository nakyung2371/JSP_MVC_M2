<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "board.BoardDTO" %>

<%
	//session 변수에 담긴 값을 불러옴: 서버의 RAM
	BoardDTO board = new BoardDTO();

	//session 변수의 값을 가지고 올 때 다운 캐스팅이 필요하다.
	board = (BoardDTO) session.getAttribute("board");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글 상세 페이지 </title>
</head>
<body>
	<center>
	<h1> 글 상세 페이지(수정 가능하도록) </h1>
	<hr>
	<br> <br>
	<form method = "post" action = "updateBoard.do">
		
		<!-- 글 수정 시 조건을 처리할 컬럼 -->
		<input type = "hidden" name = "seq" value = "<%= board.getSeq() %>">
			
		
		<table border = "1" width = "700px" cellpadding = "5px">
		<tr>
			<td bgcolor = "#FFD9EC" align = "center"> 제목 </td>
			<td> <input type = "text" name = "title" value = "<%= board.getTitle() %>"> </td>
		</tr>
		<tr>
			<td bgcolor = "#FFD9EC" align = "center"> 작성자 </td>
			<td> <input type = "text" name = "write" value = "<%= board.getWrite() %>"> </td>
		</tr>
		<tr>
			<td bgcolor = "#FFD9EC" align = "center"> 내용 </td>
			<td> <textarea name = "content" rows="10" cols="70"> <%= board.getContent() %></textarea> </td>
		</tr>
		<tr>
			<td bgcolor = "#FFD9EC" align = "center"> 등록일 </td>
			<td> <%= board.getRegdate() %> </td>
		</tr>
		<tr>
			<td bgcolor = "#FFD9EC" align = "center"> 조회수</td>
			<td> <%= board.getCnt() %></td>
		</tr>
		<tr>
			<td colspan = "2" align = "center"> <input type = "submit" value = "글 수정하기"> </td>
		</tr>
		
		</table>
	</form>
	
	<br> <br>
	<a href = "deleteBoard.do?seq=<%= board.getSeq() %>">
		글 삭제
	</a>
	
	<p/> <a href = "http://localhost:8181/JSP_MVC_M2"> 홈으로 </a>
	<p/> <a href = "getBoardList.do"> 글 목록 </a>
	<p/> <a href = "insertBoard.jsp"> 새 글 쓰기</a>
	
	
	</center>
	
	

</body>
</html>