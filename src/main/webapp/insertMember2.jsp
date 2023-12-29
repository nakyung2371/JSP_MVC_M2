<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, tr, td {
		padding: 10px;
	}
</style>
</head>
<body>
	<!-- Form 태그 내부에서 사용되는 태그들: client -- (get, podt) - -> Server 전송 
		- input:
			type = "text"		: 제목, 이름 <- 한 라인의 간단한 문자열 
			type = "password"	: ****
			type = "radio"		: 여러 값 중에 하나만 선택됨, 모든 변수명은 동일
			type = "checkbox"	: 다중 선택, 각각 변수명을 정의
			type = "file"		: 파일, 그림, 문서를 서버로 전송
			type = "button"		: 자바 스크립트를 호출 후에 submit을 적용
			type = "reset"		: form 태그의 모든 필드의 값을 초기화
			type = "submit"		: form 태그의 action = ""의 값을 호출
	
		- select: 아래로 출력되늰 내용 중 하나를 선택, name = "변수명"
			option: value = "값"
			
		- textarea: 대량의 글을 작성할 때 사용됨
		
	
	-->
	<center>
		<h2> 회원가입 입력 폼 </h2>
		<hr color = "#B2EBF4">
		<form method = "post" action = "member2Insert.ac">
			<table width = "900">
				<tr>
					<td align = "right" width = "200"> 이름: </td>
					<td> <input type = "text" name = "name" placeholder = "이름을 입력해주세요."> </td>
				</tr>
				<tr>
					<td align = "right"> 아이디: </td>
					<td> <input type = "text" name = "id" placeholder = "아이디를 입력해주세요."> 
						 <input type = "button" value = "아이디 중복 체크" name = "id_check">
					</td>
				</tr>
				<tr>
					<td align = "right"> 패스워드: </td>
					<td> <input type = "password" name = "pass1" placeholder = "비밀번호를 입력해주세요."> </td>
				</tr>
				<tr>
					<td align = "right"> 패스워드 확인: </td>
					<td> <input type = "password" name = "pass2" placeholder = "비밀번호를 한 번 더 입력해주세요."> </td>
				</tr>
				<tr>
					<td align = "right"> 성별: </td>
					<td>
						<input type = "radio" name = "sex" value = "m"> 남성		<!-- 라디오는 여러 선택지 중에 하나만 선택하는 것이기 때문에 name를 같게 설정-->
						<input type = "radio" name = "sex" value = "w"> 여성	
					</td>
				</tr>
				<tr>
					<td align = "right"> 취미: </td>	<!-- checkbox는 다중 선택이기 때문에 변수 이름이 각각 달라야 함 -->
					<td>
						<input type = "checkbox" name = "hobby1" value = "m1"> 음악 감상 &nbsp; &nbsp;
						<input type = "checkbox" name = "hobby2" value = "m2"> 독서 &nbsp; &nbsp;
						<input type = "checkbox" name = "hobby3" value = "m3"> 운동 &nbsp; &nbsp;
						<input type = "checkbox" name = "hobby4" value = "m4"> 등산 &nbsp; &nbsp;
						<input type = "checkbox" name = "hobby5" value = "m5"> 게임 &nbsp; &nbsp;
						
					</td>
				</tr>
				<tr>
					<td align = "right"> 휴대전화: </td>
					<td>
						<select name = "nation">
							<option value = "082" selected> 대한민국 </option>
							<option value = "006"> 미국 </option>
							<option value = "007"> 캐나다 </option>
							<option value = "008"> 영국 </option>
							<option value = "009"> 사우디아라비아 </option>
						</select>
						-
						<select name = "zone">						
							<option value = "011"> 011 </option>
							<option value = "012"> 012 </option>
							<option value = "016"> 016 </option>
							<option value = "017"> 017 </option>
							<option value = "010" selected> 010 </option>
						</select>
						-
						<input type = "text" name = "phone1" size = "5" maxlength = "4">
						-
						<input type = "text" name = "phone2" size = "5" maxlength = "4">
					</td>
				</tr>
				<tr>
					<td align = "right"> 자기소개서: </td>
					<td>
						<textarea rows = "10" cols = "80" name = "profile" placeholder = "입력해주세요"></textarea>
					</td>
				</tr>
				<tr>
					<td align = "right"> 첨부 사진: </td>
					<td> <input type = "file" name = "file"> * 10MB까지만 업로드해주세요.</td>
				</tr>
				<tr>
					<td colspan = "2" align = "center">
						<input type = "reset" value = "다시 작성(리셋)"> &nbsp; &nbsp;
						<input type = "submit" value = "전송(서버로 전송)">
					</td>
				</tr>
			</table>
		</form>
	</center>

</body>
</html>