package by.epam.andrewzenov.entities;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String name;
	private List<GroupOfStudents> listGroupsOfCourse;

	public Course(String name) {
		this.name = name;
		listGroupsOfCourse = new ArrayList<>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the groupsOfCourse
	 */
	public List<GroupOfStudents> getListGroupsOfCourse() {
		return listGroupsOfCourse;
	}

}
