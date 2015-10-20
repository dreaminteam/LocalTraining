package entities;

import java.util.ArrayList;
import java.util.List;

public class GroupOfStudents<Subject> {

	private String name;
	private List<Student> list;

	public GroupOfStudents(String name, List<Student> list) {
		super();
		this.name = name;
		this.list = list;
	}

	/**
	 * @return the list
	 */
	public List<Student> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Student> list) {
		this.list = list;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
