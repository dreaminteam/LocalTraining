package by.epam.andrewzenov.entities;

import by.epam.andrewzenov.subjects.Subject;

public class StudMark<T extends Number> {

	private Student student;
	private Number mark;
	private Subject subject;

	public StudMark(Student student, Subject<T> subject, Number mark) {
		super();
		this.student = student;
		this.subject = subject;
		this.mark = mark;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @return the mark
	 */
	public Number getMark() {
		return mark;
	}

	/**
	 * @return the subject
	 */
	public Subject<T> getSubject() {
		return subject;
	}

}
