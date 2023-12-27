package test;

import board.BoardDAO;
import board.BoardDTO;

public class Board_addCNT_Test {

	public static void main(String[] args) {
		//BoardDTO seq 필드의 값을 입력
		BoardDTO dto = new BoardDTO();
		dto.setSeq(3);
		
		//BoardDAO의 메소드 호출: addCNT(dto)
		BoardDAO dao = new BoardDAO();
		dao.addCNT(dto);
	}

}
