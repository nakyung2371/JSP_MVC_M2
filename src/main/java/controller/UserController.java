package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import users.UsersDAO;
import users.UsersDTO;

import java.io.IOException;

//http://localhost:8181/JSP_MVC_M2/*.us
@WebServlet("*.us")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//한글이 깨지지 않도록 처리(client -> server)
		request.setCharacterEncoding("UTF-8");
		
		//1.
		String uri = request.getRequestURI();
		//System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		//System.out.println(path);
		
		if (path.equals("/login.us")) {
			System.out.println("login.us 요청 처리");
			
			//1. client에서 넘긴 파라미터 변수 값을 받아서 변수에 저장
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. 넘겨 받은 값을 UsersDTO에 저장
			UsersDTO dto = new UsersDTO();
			dto.setId(id);
			dto.setPassword(password);
			
			//3. UsersDAO의 login(dto)
			UsersDAO dao = new UsersDAO();
			
			//리턴받을 UsersDTO 선언
			UsersDTO user = new UsersDTO();
		
			user = dao.login(dto);
			//user가 null일 경우: 인증 실패, 그렇지 않을 경우: 인증 성공
			
			if (user == null) {		//인증 실패
				System.out.println("인증 실패했습니다.");
				response.sendRedirect("LoginForm.jsp");
				
			} else {				//인증 성공
				//세션의 변수의 값을 할당하고 view 페이지로 전송
				System.out.println("인증 성공했습니다.");
				
				HttpSession session = request.getSession();
				session.setAttribute("id", user.getId());
				session.setAttribute("role", user.getRole());
				
				response.sendRedirect("LoginForm.jsp");
				
				
			}
			
		} else if (path.equals("/insertUsers.us")) {
			System.out.println("insertUsers.us 요청 처리");
			
		} else if (path.equals("/logout.us")) {
			System.out.println("logout.us 요청 처리");
			
			//1. 사용자 세션 변수의 모든 값을 삭제함
			HttpSession session = request.getSession();
			
			//세션 변수에 담긴 모든 변수의 값을 삭제
			session.invalidate();
			
			//뷰페이지로 이동(처음 페이지로 이동)
			response.sendRedirect("http://localhost:8181/JSP_MVC_M2");
		
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
