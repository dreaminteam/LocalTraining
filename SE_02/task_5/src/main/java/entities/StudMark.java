package entities;

import java.sql.Time;

public class StudMark {

	private Student student;
	private GroupOfStudents<Subject> group;
	private Time date;
	private Number mark;

	public StudMark(Student student, GroupOfStudents<Subject> group, Time date, Number mark) {
		super();
		this.student = student;
		this.group = group;
		this.date = date;
		this.mark = mark;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @return the group
	 */
	public GroupOfStudents<Subject> getGroup() {
		return group;
	}

	/**
	 * @return the date
	 */
	public Time getDate() {
		return date;
	}

	/**
	 * @return the mark
	 */
	public Number getMark() {
		if (mark.doubleValue() % 1 != 0) {
			return (Double)mark;
		} else {
			return (Integer)mark;
	}

}
