package entities;

import java.util.ArrayList;
import java.util.List;

public class JournalOfGroup {

	private List<StudMark> listOfStudMark;

	public JournalOfGroup() {
		super();
		listOfStudMark = new ArrayList<>();
	}

	/**
	 * @return the list
	 */
	public List<StudMark> getListOfStudMark() {
		return listOfStudMark;
	}

}
