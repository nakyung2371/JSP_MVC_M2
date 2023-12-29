<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- java.util.*: List, ArrayList -->
<%@ page import="java.util.*"%>
<%@ page import="board.BoardDTO"%>

<%
//Session 변수에 저장된 ArrayList를 가지고 옴
List<BoardDTO> boardList = new ArrayList<>();

//세션에서 가져온 값은 Object 타입이어서 (List 타입으로 변환)
try {
	boardList = (List<BoardDTO>) session.getAttribute("boardList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>글 목록</h1>
		<hr>
		<!-- 검색 기능 추가 - 시작 -->
		<table border = "1" width ="700px">
			<tr><td>
				<form method = "post" action = "getBoardList.do">
					<select name ="searchCondition">
						<option value = "TITLE"> 제목 검색 </option>
						<option value = "WRITE"> 글쓴이 검색 </option>
						<option value = "CONTENT"> 내용 검색 </option>
						<option value = "REGDATE"> 날짜 검색 </option>
					</select>
					
					<input type = "text" name = "searchKeyword" size = "40">
					<input type = "submit" value = "검색 시작">
					
				</form>
			</td></tr>	
		</table>
		* 날짜 검색 시: 23/12/29 형식으로 검색어에 넣으세요
		<!-- 검색 기능 추가 - 끝 -->
		<p/>
		<table border="1" width="700px">
			<tr>
				<th bgcolor="#FFD9EC" width="100px">번호</th>
				<th bgcolor="#FFD9EC" width="200px">제목</th>
				<th bgcolor="#FFD9EC" width="150px">작성자</th>
				<th bgcolor="#FFD9EC" width="150px">등록일</th>
				<th bgcolor="#FFD9EC" width="100px">조회수</th>
			</tr>

			<!-- ArrayList의 BoardDTO를 꺼내서 출력 : loop 돌리면서 출력  -->
			<%
			for (BoardDTO k : boardList) {
			%>

			<tr>
				<td align="center"><%=k.getSeq()%></td>
				<!-- 제목에 링크를 건다: 글 상세 내용을 볼 수 있도록 -->
				<td><a href="getBoard.do?seq=<%=k.getSeq()%>"> <%=k.getTitle()%>
				</a></td>
				<td><%=k.getWrite()%></td>
				<td><%=k.getRegdate()%></td>
				<td><%=k.getCnt()%></td>
			</tr>

			<%
			}

			//모두 사용됨: boardList
			//세션 변수의 값을 제거: 서버의 메모리에서 세션 변수 boardList에 저장한 값을 제거
			session.removeAttribute("boardList");

			} catch (Exception e) {
			response.sendRedirect("getBoardList.do");
			}
			%>

		</table>
		

		<br> <a href = "http://localhost:8181/JSP_MVC_M2"> 홈으로 </a>
		<p/> <a href = "insertBoard.jsp"> 새 글 쓰기</a>
		
	</center>
</body>
</html>