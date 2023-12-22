package test;

import java.sql.*;

import common.JDBCUtil;

public class DB_testTbl_Insert_Test {

	public static void main(String[] args) {

		String sql = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		conn = JDBCUtil.getConnection();
		
		sql = "insert into testTbl(id, name, email) ";
		sql += "values ( nvl(((select Max(id) from testTbl) + 1), 1), ";
		sql += "?, ?)";
		
		//자바에서는 pstmt에서는 예외 처리가 필요함
		try {			
			//pstmt 활성화
			pstmt = conn.prepareStatement(sql);
			
			//stmt의 ?에 변수값 할당
			for (int i = 0; i < 1000; i++) {
				pstmt.setString(1, "홍길동 - " + i);
				pstmt.setString(2, "aaa@aaa.com - " + i);
				
				pstmt.executeUpdate();
			}
				
			System.out.println("DB에 1000개의 레코드가 잘 저장되었습니다.");
			
		} catch (Exception e) {
			//try {}에 오류가 있을 때만 작동
			System.out.println("저장 중 오류가 발생되었습니다.");
			e.printStackTrace();
			
		} 
		
		JDBCUtil.close(pstmt, conn);
	}

}
