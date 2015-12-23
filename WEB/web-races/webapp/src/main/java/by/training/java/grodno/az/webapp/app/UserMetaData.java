package by.training.java.grodno.az.webapp.app;

import java.io.Serializable;

public class UserMetaData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String userFName;
	private String userLName;
	private String userEmail;

	public String getFullName(){
		return String.format("%s %s", userFName,userLName);
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
