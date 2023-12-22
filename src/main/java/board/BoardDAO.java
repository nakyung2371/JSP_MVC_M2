package board;

import java.sql.*;

import common.JDBCUtil;
public class BoardDAO {
	//DAO: DataBase의 Board 테이블을 접근하는 객체: SQL 쿼리
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	
	//sql 쿼리를 상수로 지정함
	private final String BOARD_INSERT = 
			"insert into board (seq, title, write, content) "
			+ "valuse ((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";

	//insertBoard(BoardDTO dto) 메소드:
	public void insertBoard (BoardDTO dto) {
		System.out.println("= insertBoard 기능 처리 =");
		
		try {
			
			//conn, pstmt 객체 활성화
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			
			//pstmt 객체의 ? 변수의 값 할당
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWrite());
			pstmt.setString(3, dto.getContent());
			
			//pstmt를 실행히ㅐ서 DB에 저장
			pstmt.executeUpdate();
			System.out.println("board 테이블에 값이 잘 insert 되었습니다.");
			
		} catch (Exception e) {
			System.out.println("board 테이블에 값이 insert 실패 되었습니다.");
			e.printStackTrace();
			
		} finally {
			//사용한 객체 제거
			JDBCUtil.close(pstmt, conn);
		}
	}

}
