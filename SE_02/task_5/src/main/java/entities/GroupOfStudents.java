package entities;

import java.util.ArrayList;
import java.util.List;

public class GroupOfStudents<T extends Subject> {

	private String name;
	private List<Student> listOfStudent;
	private Subject subject;
	private JournalOfGroup journalOfStudMark;

	public GroupOfStudents(T subject, String name) {
		super();
		this.subject = subject;
		this.name = name;
		listOfStudent = new ArrayList<>();
		journalOfStudMark = new JournalOfGroup();

	}

	/**
	 * @return the journalOfStudMark
	 */
	public JournalOfGroup getJournalOfStudMark() {
		return journalOfStudMark;
	}



	public <R> void fill(List<R> list, R val) {
		for (int i = 0; i < list.size(); i++)
			list.set(i, val);
	}

	/**
	 * @return the list
	 */
	public List<Student> getListOfStudent() {
		return listOfStudent;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setListOfStudent(List<Student> list) {
		this.listOfStudent = list;
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
