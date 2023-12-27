package test;

import users.UsersDAO;
import users.UsersDTO;

public class Users_login_Test {

	public static void main(String[] args) {
		//1. UsersDTO: id, password
		UsersDTO dto = new UsersDTO();
		dto.setId("user");
		dto.setPassword("1234");
		
		//2. UsersDAO: login(dto) 리턴된 값이 null이라면 인증 실패, 그렇지 않으면 인증 성공
		UsersDAO dao = new UsersDAO();
		
		//리턴 받을 UsersDTO 선언
		UsersDTO user = new UsersDTO();
		
		user = dao.login(dto);
		
		if (user != null) {
			System.out.println("인증 성공");
			System.out.println(user);
			
		} else {
			System.out.println("인증 실패");
			System.out.println(user);
		}

	}

}
