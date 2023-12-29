package member2;

import java.sql.*;

import common.JDBCUtil;

public class Member2DAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private final String MEMBER2_INSERT =
			"insert into member2 (id, name, pass1, sex, hobby1, hobby2, hobby3, hobby4, nation, zone, phone1, phone2, profile) "
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	//member2Insert(Member2DTO dto) 메소드:
	public void member2Insert(Member2DTO dto) {
		System.out.println("= member2Insert 기능 처리 =");
		
		try {
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER2_INSERT);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPass1());
			pstmt.setString(4, dto.getSex());
			pstmt.setString(5, dto.getHobby1());
			pstmt.setString(6, dto.getHobby2());
			pstmt.setString(7, dto.getHobby3());
			pstmt.setString(8, dto.getHobby4());
			pstmt.setString(9, dto.getNation());
			pstmt.setString(10, dto.getZone());
			pstmt.setString(11, dto.getPhone1());
			pstmt.setString(12, dto.getPhone2());
			pstmt.setString(13, dto.getProfile());
			
			pstmt.executeUpdate();
			System.out.println("member2 테이블에 값이 잘 insert 되었습니다.");
			
		} catch (Exception e) {
			System.out.println("member2 테이블에 값 insert를 실패하였습니다.");
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

}
/*
 * 	private String id;
	private String name;
	private String pass1;
	private String sex;
	private String hobby1;
	private String hobby2;
	private String hobby3;
	private String hobby4;
	private String nation;
	private String zone;
	private String phone1;
	private String phone2;
	private String profile;
*/