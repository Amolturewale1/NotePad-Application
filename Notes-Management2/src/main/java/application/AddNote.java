package application;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addNote")
public class AddNote extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		String title=req.getParameter("title");
		String note=req.getParameter("note");
		
		System.out.println(userName);
		System.out.println(password);
		System.out.println(title);
		System.out.println(note);
		Service s1=new Service();
		int userId=s1.getuserId(userName);
		
		Date d1=new Date();
		String dateTime=String.valueOf(d1);
		
		Notes newnote=new Notes(title,note,dateTime);
		if (title.length()<=20) {
			boolean status =s1.addNote(newnote,userId);
		 	if(status) {
		 		req.setAttribute("username", userName);
		 		req.setAttribute("password", password);
		 		RequestDispatcher rd=req.getRequestDispatcher("login");
		 		rd.forward(req, resp);
		 	}else {
		 		resp.setContentType("text/html");
		 		req.setAttribute("username", userName);
		 		req.setAttribute("password", password);
				resp.getWriter().print("<h1>Title Not Available</h1");
		 		RequestDispatcher rd=req.getRequestDispatcher("addNote.jsp");
		 		rd.include(req, resp);
			}
		}else {
			resp.setContentType("text/html");
	 		req.setAttribute("username", userName);
	 		req.setAttribute("password", password);
			resp.getWriter().print("<h1>title too long</h1");
	 		RequestDispatcher rd=req.getRequestDispatcher("addNote.jsp");
	 		rd.include(req, resp);
		}
	 	
	}

}
