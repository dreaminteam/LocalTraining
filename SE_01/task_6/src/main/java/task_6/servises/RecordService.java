package task_6.servises;

import task_6.entities.Record;

/**
 * Service for working on Records
 * 
 * @author AndrewZenov
 * @version JDK_1.8
 */
public class RecordService {

	/**
	 * Method for creating new Record only with one parameter
	 * 
	 * @param title
	 *            the title of Record
	 * @return Record
	 */
	public Record createRecord(String title) {
		return new Record(title);
	}

	/**
	 * Method for creating new Record
	 * 
	 * @param title
	 *            the title of Record
	 * @param content
	 *            the content of Record
	 * @return Record
	 */
	public Record createRecord(String title, String content) {
		return new Record(title, content);

	}

	/**
	 * @param record
	 *            the any Record
	 * @param newTitle
	 *            the new title for record
	 */
	public void updateTitle(Record record, String newTitle) {
		record.setTitle(newTitle);
	}

	/**
	 * @param record
	 *            the any Record
	 * @param newContent
	 *            the new content for record
	 */
	public void updateRecord(Record record, String newContent) {
		record.setContent(newContent);
	}

}
