package by.epam.andrewzenov.entities;

import java.sql.Time;

public class StudMark {

	private Student student;
	private GroupOfStudents group;
	private Time date;
	private Number mark;

	public StudMark(Student student, GroupOfStudents group, Time date, Number mark) {
		super();
		this.student = student;
		this.group = group;
		this.date = date;
		this.mark = (group.getSubject().getT())mark;
	}

	public Student getStudent() {
		return student;
	}

	public GroupOfStudents getGroup() {
		return group;
	}

	public Time getDate() {
		return date;
	}

	public Number getMark() {
		if (mark.doubleValue() % 1 != 0) {
			return (Double)mark;
		} else {
			return (Integer)mark;
	}

}
