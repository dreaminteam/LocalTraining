package entities;

import java.util.ArrayList;
import java.util.List;

public class GroupOfStudents<T extends Subject> {

	private String name;
	private List<Student> list;
	private Subject subject;

	public GroupOfStudents(T subject, String name) {
		super();
		this.subject = subject;
		this.name = name;
		list = new ArrayList<>();

	}

	public void addMarkToStudent(Student student, double mark) {
		if (!subject.isInt()) {
			student.setMark(mark);
			return;
		}
		student.setMark(mark);

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

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

}
