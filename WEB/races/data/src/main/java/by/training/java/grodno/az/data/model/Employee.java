package by.training.java.grodno.az.data.model;

import java.util.List;

public class Employee extends User{

	private int id;
	private List<AccessLevel> permission;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public List<AccessLevel> getPermission() {
		return permission;
	}

	public void setPermission(List<AccessLevel> permission) {
		this.permission = permission;
	}
	
}
