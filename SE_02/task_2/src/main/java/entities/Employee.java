package entities;

import java.util.ArrayList;

public class Employee {

	private int id;
	private String name;
	private String surName;
	private String position;
	private ArrayList<Stationery> list = new ArrayList<>();

	public Employee(String name, String surName, String position) {
		this.name = name;
		this.surName = surName;
		this.position = position;
	}

	public Employee(int id, String name, String surName, String position) {
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.position = position;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(ArrayList<Stationery> list) {
		this.list = list;
	}

	/**
	 * @return the list of Stationery
	 */
	public ArrayList<Stationery> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surName=" + surName + ", position=" + position
				+ ", stationery=" + list.toString() + "]";
	}

}
