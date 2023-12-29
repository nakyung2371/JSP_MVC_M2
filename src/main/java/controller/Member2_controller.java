package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member2.Member2DAO;
import member2.Member2DTO;

import java.io.IOException;

//http://localhost:8181/JSP_MVC_M2/*.ac
@WebServlet ("*.ac")
public class Member2_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Member2_controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//한글이 깨지지 않도록 처리
		request.setCharacterEncoding("UTF-8");
		System.out.println("ac 요청을 처리하는 controller입니다.");
		
		//	URL : http://localhost:8181/JSP_MVC_M2/my.ac
		// 	URI : /JSP_MVC_M2/my.ac
		
		String uri = request.getRequestURI();
		System.out.println("uri");
		
		String path = uri.substring(uri.lastIndexOf("/")); 
		System.out.println(path);
		System.out.println("====================");
		
		if (path.equals("/member2Insert.ac")) {
			System.out.println("/member2Insert.ac 요청");
			
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String pass1 = request.getParameter("pass1");
			String sex = request.getParameter("sex");
			String hobby1 = request.getParameter("hobby1");
			String hobby2 = request.getParameter("hobby2");
			String hobby3 = request.getParameter("hobby3");
			String hobby4 = request.getParameter("hobby4");
			String nation = request.getParameter("nation");
			String zone = request.getParameter("zone");
			String phone1 = request.getParameter("phone1");
			String phone2 = request.getParameter("phone2");
			String profile = request.getParameter("profile");

			Member2DTO dto = new Member2DTO();
			dto.setId(id);
			dto.setName(name);
			dto.setPass1(pass1);
			dto.setSex(sex);
			dto.setHobby1(hobby1);
			dto.setHobby2(hobby2);
			dto.setHobby3(hobby3);
			dto.setHobby4(hobby4);
			dto.setNation(nation);
			dto.setZone(zone);
			dto.setPhone1(phone1);
			dto.setPhone2(phone2);
			dto.setProfile(profile);
			
			Member2DAO dao = new Member2DAO();
			dao.member2Insert(dto);
			
			response.sendRedirect("LoginForm.jsp");
			
			
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
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
