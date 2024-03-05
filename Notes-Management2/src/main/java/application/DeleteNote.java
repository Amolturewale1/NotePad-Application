package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteNote extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		Service s1=new Service();
		int userId=s1.getuserId(username);
		String password=req.getParameter("password");
		String title=req.getParameter("title");
		
		System.out.println("delete Servlet "+userId+" "+password+" "+title);
		boolean status=s1.deleteNote(title,userId);
		if(status) {
			 RequestDispatcher rd = req.getRequestDispatcher("login?username=" + username + "&password=" + password);
			 rd.forward(req, resp);
		}
		
				
	}
}
