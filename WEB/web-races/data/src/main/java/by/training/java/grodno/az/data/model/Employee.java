package by.training.java.grodno.az.data.model;

public class Employee extends User {

	private int id;
	private char role;
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getRole() {
		return role;
	}

	public void setRole(char role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", role=" + role + ", userId=" + userId + "]";
	}

}
