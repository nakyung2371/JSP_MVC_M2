package test;

import board.BoardDAO;
import board.BoardDTO;

public class Board_deleteBoard_Test {
		public static void main(String[] ards) {
			//1. BoardDTO에 seq의 값을 할당
			BoardDTO dto = new BoardDTO();
			dto.setSeq(9);
			
			//2. BoardDAO의 deleteBoard(dto)
			BoardDAO dao = new BoardDAO();
			dao.deleteBoard(dto);
						
		}

}
