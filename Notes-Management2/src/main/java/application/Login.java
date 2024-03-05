package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		User user = (User) req.getAttribute("User");
		

		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(user!=null) {
			username=user.getUserName();
			password=user.getPassword();
		}
		
		
		String title=req.getParameter("title");
		System.out.println("----login page");
		System.out.println(username);
		System.out.println(password);
		System.out.println(title);
		PrintWriter out=resp.getWriter();
		Service s1=new Service();
		User u1=new User();
		u1.setUserName(username);
		u1.setPassword(password);
		
		boolean status= s1.login(u1);
		if(status) {
			int userId=s1.getuserId(username);
			System.out.println(userId);
			List<Notes> noteList=null;
			if(user!=null) {
				username=user.getUserName();
				password=user.getPassword();
				noteList = (List<Notes>) req.getAttribute("noteList");
				
				
			}else {
				noteList=s1.getAllNotesByuserId(userId);
			}
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			req.setAttribute("noteList", noteList);
			req.setAttribute("userId", userId);
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}else {
			System.out.println(status);
			resp.setContentType("text/html");
			out.print("<h1>Login Feiled</h1");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
	
}
