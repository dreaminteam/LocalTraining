package by.training.java.grodno.az.data.model;

public class Player extends User {

	private int id;
	private String email;
	private Double balance;
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", email=" + email + ", balance=" + balance + ", userId=" + userId + "]";
	}

}
