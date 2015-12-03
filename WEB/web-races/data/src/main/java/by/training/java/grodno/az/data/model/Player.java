package by.training.java.grodno.az.data.model;

public class Player extends User {

	private int id;
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", userId=" + userId + "]";
	}

}
