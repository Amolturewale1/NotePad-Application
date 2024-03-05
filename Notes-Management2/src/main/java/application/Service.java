package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Service {
	Connection conn=GetConnetion.conn;
	
	public boolean login(User user) {
		boolean status=false;
		String loginQuery="select * from user_info where user_name=? and user_password=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(loginQuery);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				status=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int getuserId(String userName) {
		int userId = 0;
	    String selectQuery = "select * from user_info where user_name=?";
	    
	    try {
	    	
	        
	    	PreparedStatement pstmt=conn.prepareStatement(selectQuery);
	    	pstmt.setString(1, userName);
	    	
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            userId = rs.getInt(1);
	        } else {
	            System.out.println("User not found for username: " + userName);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userId;
	}

	public List<Notes> getAllNotesByuserId(int userId) {
		
		List<Notes> noteList=new ArrayList<Notes>();
		String selectQuery="Select title,date_time,note from note_info where user_id="+userId;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(selectQuery);
			while(rs.next()) {
				Notes n1=new Notes();
				n1.setTitle(rs.getString(1));
				n1.setDateTime(rs.getString(2));
				n1.setNote(rs.getString(3));
				noteList.add(n1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noteList;
	}

	public boolean addNote(Notes newnote,int userId) {
		String 	insertQuery="insert into note_info (user_id,title,note,date_time) values(?,?,?,?)";
		
		boolean status=false;
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(insertQuery);
			pstmt.setInt(1, userId);
			pstmt.setString(2, newnote.getTitle());
			pstmt.setString(3, newnote.getNote());
			pstmt.setString(4, newnote.getDateTime());
			pstmt.executeUpdate();
			status=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

	public Notes viewNote(int userId, String title) {
		String selectQuery="Select note,date_time from note_info where title=? and user_id=?";
		System.out.println(title);
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectQuery);
			pstmt.setString(1, title);
			pstmt.setInt(2, userId);
			System.out.println(selectQuery);
			ResultSet rs= pstmt.executeQuery();
			if (rs.next()) {
				Notes n1=new Notes();
				System.out.println(rs.getString(1));
				n1.setNote(rs.getString(1));
				n1.setTitle(title);
				n1.setDateTime(rs.getString(2));
				return n1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}

	public int getNoteId(String title, int userId) {
		String selectQuery="Select note_id from note_info where user_id=? and title=?";
		System.out.println(title);
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectQuery);
			pstmt.setInt(1, userId);
			pstmt.setString(2, title);
			System.out.println(selectQuery);
			ResultSet rs= pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return 0;
	}

	public boolean updateNote(Notes n1) {
		boolean status=false;
		String updateQuery="update note_info set title=?,note=?,date_time=? where note_id=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateQuery);
			pstmt.setString(1, n1.getTitle());
			pstmt.setString(2, n1.getNote());
			pstmt.setString(3, n1.getDateTime());
			pstmt.setInt(4, n1.getNoteId());
			System.out.println("update Q:"+updateQuery);
			pstmt.executeUpdate();
			status=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

	public boolean deleteNote(String title, int userId) {
		boolean status=false;
		String deleteQuery="delete from note_info where title=? and user_id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(deleteQuery);
			pstmt.setString(1, title);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
			status=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	public void addUser(User u1) {
		String insertQuery="insert into user_info (user_name,user_password) values(?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insertQuery);
			pstmt.setString(1, u1.getUserName());
			pstmt.setString(2, u1.getPassword());
			System.out.println(u1.getUserName()+" "+u1.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Notes> getNoteBySearch(int userId, String searchTitle) {
		List<Notes> noteList=new ArrayList();
		String selectQuery="select * from note_info where user_id=? and title like ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectQuery);
			pstmt.setInt(1, userId);
			pstmt.setString(2, searchTitle);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				Notes n1=new Notes();
				n1.setTitle(rs.getString(3));
				n1.setDateTime(rs.getString(5));
				n1.setNote(rs.getString(4));
				noteList.add(n1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return noteList;
	}

	public boolean findUser(User u1) {
		
		String findUser="select * from user_info where user_name=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(findUser);
			pstmt.setString(1, u1.getUserName());
			System.out.println("findUser "+u1.getUserName());
			ResultSet rs= pstmt.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
		
}



