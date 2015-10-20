package entities;

public class Student {
	
	private String name;
	private String surName;
	private int age;
	
	
	
	
	public Student(String name, String surName, int age) {
		super();
		this.name = name;
		this.surName = surName;
		this.age = age;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}
	
	

}
