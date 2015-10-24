package by.epam.andrewzenov.entities;

import java.util.ArrayList;
import java.util.List;

import by.epam.andrewzenov.subjects.Subject;

public class GroupOfStudents {

	private String name;
	private Subject subject;
	private List<Student> listOfStudent;
	private List<StudMark> listStudMarkOfGroup;

	public GroupOfStudents(String name, Subject subject) {
		this.name = name;
		this.subject = subject;
		this.listOfStudent = new ArrayList<>();
		this.listStudMarkOfGroup=new ArrayList<>();
	}

	public List<StudMark> getListStudMarkOfGroup() {
		return listStudMarkOfGroup;
	}

	public String getName() {
		return name;
	}

	public Subject<Number> getSubject() {
		return subject;
	}

	public List<Student> getListOfStudent() {
		return listOfStudent;
	}

	public void setListOfStudent(List<Student> list) {
		this.listOfStudent = list;
	}


}
