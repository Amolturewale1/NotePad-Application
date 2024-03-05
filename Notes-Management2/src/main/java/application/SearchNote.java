package application;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/search")
public class SearchNote extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service s1=new Service();
		
		String userName=req.getParameter("userName");
		int userId=s1.getuserId(userName);
		String password=req.getParameter("password");
		User u1=new User();
		u1.setUserName(userName);
		u1.setPassword(password);
		String searchTitle=req.getParameter("searchTitle");
		System.out.println("Search servlet "+userName+" "+password+" "+searchTitle);
		
		List<Notes> noteList= s1.getNoteBySearch(userId,searchTitle);
		if(noteList!=null) {
			req.setAttribute("User", u1);
			req.setAttribute("noteList", noteList);
			req.setAttribute("userId", userId);
			RequestDispatcher rd=req.getRequestDispatcher("login");
			rd.forward(req, resp);
		}
		
	}

}
