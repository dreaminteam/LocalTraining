package by.training.java.grodno.az.data.entities;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
