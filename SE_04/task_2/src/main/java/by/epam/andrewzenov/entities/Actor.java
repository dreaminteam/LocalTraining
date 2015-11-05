package by.epam.andrewzenov.entities;

import java.io.Serializable;

public class Actor implements Serializable {
	final private String name;
	final private String surname;

	public Actor(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public String toString(){
		return String.format("Author[%s %s]", name,surname);
	}
	
}
