package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forword")
public class ForwordUserInfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Assuming request is an HttpServletRequest object
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		req.setAttribute("username", username);
		req.setAttribute("password", password);
		System.out.println("forword Servlet");
		System.out.println(username+" "+password);
		RequestDispatcher dispatcher = req.getRequestDispatcher("addNote.jsp");
		dispatcher.forward(req, resp);

	}
}
