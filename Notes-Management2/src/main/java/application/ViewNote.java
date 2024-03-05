package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/viewNote")
public class ViewNote extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("username");
		String title=req.getParameter("title");
		String password=req.getParameter("password");
		System.out.println("----------viewNote Servlet--------------");
		System.out.println("title"+title);
		System.out.println("username "+userName);
		System.out.println("password "+password);
		Service s1=new Service();
		int userId=s1.getuserId(userName);
		
		Notes n1= s1.viewNote(userId,title);
		if (!n1.equals(null)) {
			req.setAttribute("note", n1);
			req.setAttribute("userId", userId);
			req.setAttribute("userName", userName);
			req.setAttribute("password", password);
			RequestDispatcher rd=req.getRequestDispatcher("viewnote.jsp");
			rd.forward(req, resp);
		}else {
			resp.setContentType("text/html");
			resp.getWriter().print("<h1>Error</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			rd.include(req, resp); 
		}
		
	}
}
