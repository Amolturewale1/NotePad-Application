package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class updateNote extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userId"));
		String useName=req.getParameter("userName");
		String password=req.getParameter("password");
		String title=req.getParameter("title");
		String note=req.getParameter("note");
		String dateTime=req.getParameter("dateTime");
		System.out.println("-----------updateServlet---------S");
		System.out.println(userId+" "+title+" "+password);
		System.out.println("-------------");
		
		req.setAttribute("title", title);
		req.setAttribute("userId", userId);
		req.setAttribute("note", note);
		req.setAttribute("userName", useName);
		req.setAttribute("password", password);
		req.setAttribute("dateTime", dateTime);
		RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
		rd.forward(req, resp);
	}

}
