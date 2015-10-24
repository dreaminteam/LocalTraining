package by.epam.andrewzenov.entities;

import by.epam.andrewzenov.subjects.Subject;

public class StudMark implements Comparable<StudMark> {

	private Student student;
	private Number mark;
	private Subject subject;

	public <T extends Number> StudMark(Student student, Subject<T> subject, T mark) {
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
	public Subject getSubject() {
		return subject;
	}

	@Override
	public int compareTo(StudMark o) {
		double result = this.getMark().doubleValue() - o.getMark().doubleValue();
		if (result > 0) {
			return 1;
		} else {
			if (result < 0) {
				return -1;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return String.format("[Studen:%s, Subject:%s, Mark:%s]", student, subject, mark);
	}

}
