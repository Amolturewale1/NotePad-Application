package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String confPassword=req.getParameter("confirm_password");
		
		System.out.println(username+" "+password+" "+confPassword);
		if(password.equals(confPassword)) {
			Service s1=new Service();
			User u1=new User();
			u1.setUserName(username);
			u1.setPassword(password);
			if( username.length()>20) {
				resp.setContentType("text/html");
				resp.getWriter().print("<h1>Username Too Long </h1");
				RequestDispatcher rd=req.getRequestDispatcher("register2.html");
				rd.include(req, resp);
			}else {
				if (s1.findUser(u1)) {
					resp.setContentType("text/html");
					resp.getWriter().print("<h1>Username Not Available</h1");
					RequestDispatcher rd=req.getRequestDispatcher("register2.html");
					rd.include(req, resp);
				}else {
					s1.addUser(u1);
					RequestDispatcher rd=req.getRequestDispatcher("index.html");
					rd.forward(req, resp);
				}
			
			}
		}else {
			
			resp.setContentType("text/html");
			resp.getWriter().print("<h1>Password Wrong</h1");
			RequestDispatcher rd=req.getRequestDispatcher("register2.html");
			rd.include(req, resp);
		}
	}
}
