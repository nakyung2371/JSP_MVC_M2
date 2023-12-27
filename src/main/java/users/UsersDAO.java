package users;

import java.sql.*;

import common.JDBCUtil;

public class UsersDAO {
	//SQL 쿼리를 접근하는 객체 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//sql 쿼리를 적용하는 상수 선언
	private final String USERS_LOGIN = "select * from users where id = ? and password = ?";
	
	//메소드
	public UsersDTO login(UsersDTO dto) {
		System.out.println("login 메소드 호출");
		
		//리턴으로 돌려줄 UserDTO <- null, dto
		UsersDTO user = null;
		
		try {
			conn = JDBCUtil.getConnection();
			//USERS_LOGIN = "select * from users where id = ? and password = ?"
			pstmt = conn.prepareStatement(USERS_LOGIN);
			
			//? 변수의 값 할당
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			
			//pstmt 실행 후 rs로 쿼리한 레코드 저장
			rs = pstmt.executeQuery();		//select
			
			//rs의 값이 존재할 때 인증 성공: 레코드 1개가 출력
			while (rs.next()) {
				//리턴으로 돌려줄 dto 선언
				user = new UsersDTO();
				
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setRole(rs.getString("ROLE"));
				
				System.out.println(" - 인증 성공: 해당 ID와 Password가 DB에 존재합니다.");
			}
			
			
		} catch (Exception e) {
			System.out.println("인증 시 문제가 발생했습니다.");
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
				
		return user;
	}
	
}
