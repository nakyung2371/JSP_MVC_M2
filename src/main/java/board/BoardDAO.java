package board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil; 

public class BoardDAO {
	// DAO : DataBase의 Board 테이블을 접근 하는 객체 : SQL 쿼리 
	
	Connection conn = null; 
	PreparedStatement pstmt = null ; 
	ResultSet rs = null ; 
		
	//sql 쿼리를 상수로 지정함. 
	//insert 쿼리
	private final String BOARD_INSERT = 
		"insert into board (seq, title, write, content) "
		+ "values ((select nvl(max(seq),0) + 1 from board ), ? , ? , ? )";
     
	//DB의 Board 테이블의 모든 레코드를 출력하는 쿼리: 레코드가 여러 개: dto -> ArrayList 리턴
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	//DB의 Board 테이블의 글 상세 조회: 레코드 1개 <- dto
	private final String BOARD_GET = "select * from board where seq = ?";
	
	//insertBoard(BoardDTO dto) 메소드  : 
	public void insertBoard (BoardDTO dto) {
		System.out.println("= insertBoard 기능 처리 =");
		
		try {
			
			//conn, pstmt 객체 활성화 
			conn = JDBCUtil.getConnection() ; 
			pstmt= conn.prepareStatement(BOARD_INSERT); 
			
			//pstmt 객체의 ? 변수의 값 할당. 
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWrite());
			pstmt.setString(3, dto.getContent());
			
			//pstmt 를 실행해서 DB에 저장 
			pstmt.executeUpdate(); 
			
			System.out.println("board 테이블에 값이 잘 insert 되었습니다. ");
			
		}catch (Exception e) {
			System.out.println("board 테이블에 값이 insert에 실패 했습니다. ");
			e.printStackTrace();
		} finally {
			//사용한 객체 제거 
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	//Board 테이블의 전체 레코드를 출력하는 메소드
	//DB의 레코드 하나를 BoardDTO에 담는다. 각각의 BoardDTO를 ArrayList에 담아서 리턴
	//rs, pstmt, conn
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		//중요: ArrayList는 While 블락 밖에서 선언
		//	   ArrayList에 저장되는 BoardDTO 선언은 While 블락 안에서 선언
		
		List<BoardDTO> boardList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();	//conn 객체 활성화: Oracle, XE, HR12, 1234
			pstmt = conn.prepareStatement(BOARD_LIST);
			
			//pstmt를 실행 후 rs에 레코드를 저장
			rs = pstmt.executeQuery();
			
			//System.out.println("DB Select 성공");
			
			//rs의 각 레코드를 BoardDTO에 저장 -> 각각의 DTO를 ArrayList에 저장
				//if, do ~ while <-> while
				//rs.next(): 다음 레코드가 존재하면 true, 커서가 다음 레코드로 이동
			
			//BoardDTO board = new BoardDTO(); 		//밖에서 BoardDTO를 선언할 시 1번째 레코드만 반복 출력이 됨
			
			while (rs.next()) { //한번 호출이 되면
				//BoardDTO 객체 생성
				
				BoardDTO board = new BoardDTO();	//루프 블락 내에 선언 | while문 안에 선언해야 함
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWrite(rs.getString("WRITE"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				//boardList: ArrayList의 add 메소드를 사용해서 boardDTO를 저장함
				boardList.add(board);
			}
			
		} catch (Exception e) {
			System.out.println("DB Select 실패");
			e.printStackTrace();	//실패할 경우 콘솔에 오류 정보 출력
			
		} finally {
			//사용한 객체 반납: rs, pstmt, conn
			JDBCUtil.close(rs, pstmt, conn);
			
		}
				
		return boardList;
	}
	
	//글 상세 조회: getBoard(dto) 
	public BoardDTO getBoard(BoardDTO dto) {
		BoardDTO board = new BoardDTO();
		System.out.println("getBoard 메소드 호출 성공");
		
		try {
			conn = JDBCUtil.getConnection();
			//BOARD_GET = "select * from board where seq = ?"
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, dto.getSeq());
			
			//rs: 레코드 1개
			rs = pstmt.executeQuery();
			
			//rs의 값이 존재할 때
			while (rs.next()) {
				
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWrite(rs.getString("WRITE"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				System.out.println("RS의 레코드를 dto 저장 성공");
			}
			
		} catch (Exception e) {
			System.out.println("글 상세 조회 실패");
			e.printStackTrace();			
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return board;
	}

	
}
