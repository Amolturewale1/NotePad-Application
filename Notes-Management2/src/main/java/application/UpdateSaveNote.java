package application;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/saveUpdateNote")
public class UpdateSaveNote extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("userId");
		String username=req.getParameter("userName");
		String password=req.getParameter("password");
		String dateTime=req.getParameter("dateTime");
		System.out.println(id);
		int userId=Integer.parseInt(id);
		String oldTitle=req.getParameter("titleOld");
		String title=req.getParameter("title");
		
		String note=req.getParameter("note");
		System.out.println("UpdateSaveNote "+userId+" "+ title+" "+note+" "+username+" "+password);
		
		Service s1=new Service();
		Notes n1=new Notes();
		n1.setTitle(title);
		n1.setNote(note);
		Date d1=new Date();
		dateTime=String.valueOf(d1);
		System.out.println(dateTime);
		n1.setDateTime(dateTime);
		int noteId=s1.getNoteId(oldTitle,userId);
		System.out.println("note id:"+noteId);
		n1.setNoteId(noteId);
		if(noteId!=0) {
		  boolean status=s1.updateNote(n1);
		  if(status) {
			  
			  RequestDispatcher rd = req.getRequestDispatcher("login?username=" + username + "&password=" + password);
			  rd.forward(req, resp);
		  }else {
			  System.out.println("status:"+status);
		  }
		}else {
			System.out.println("noteId"+noteId);
		}
	}
}
