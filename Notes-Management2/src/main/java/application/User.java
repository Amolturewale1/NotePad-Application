package application;

public class User {
	private int userId;
	private String userName;
	private String password;
	
	public User() {
		
	}

	

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public User(int userId, String userName, String password) {
		
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	
	
	

}
