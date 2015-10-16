package task_6.entities;

import java.time.LocalDate;

/**
 * This class description entity record. Record has four properties.
 * 
 * @author AndrewZenov
 * @version JDK_1.8
 */
public class Record {

	/**
	 * dateCreateRecord - creating date of new Record. lastChangeRecord - date
	 * last record's changing. content - content of Record. title - title of
	 * Record
	 */
	private LocalDate dateCreateRecord;
	private LocalDate lastChangeRecord;
	private String content;
	private String title;

	/**
	 * 
	 * @param title
	 *            the title of Record
	 */
	public Record(String title) {
		this.title = title;
		this.dateCreateRecord = LocalDate.now();
		this.lastChangeRecord = this.dateCreateRecord;
		this.content = "";
	}

	/**
	 * 
	 * @param title
	 *            the title of Record
	 * @param content
	 *            the content of Record
	 */
	public Record(String title, String content) {
		this.title = title;
		this.dateCreateRecord = LocalDate.now();
		this.lastChangeRecord = this.dateCreateRecord;
		this.content = content;
	}

	/**
	 * Return date of creating of Record
	 * 
	 * @return the dateCreateRecord
	 */
	public LocalDate getDateCreateRecord() {
		return dateCreateRecord;
	}

	/**
	 * Return date last record's changing
	 * 
	 * @return the lastChangeRecord
	 */
	public LocalDate getLastChangeRecord() {
		return lastChangeRecord;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Set content for Record. Set new lastChangeRecord
	 * 
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
		this.lastChangeRecord = LocalDate.now();
	}

	/**
	 * Return title of record
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set title for Record Set new lastChangeRecord
	 * 
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
		this.lastChangeRecord = LocalDate.now();
	}

	@Override
	public String toString() {
		return ">>>>>>>>>>>>>>" + '\n' + "Created record : " + getDateCreateRecord() + '\n' + "Last change record : "
				+ getLastChangeRecord() + '\n' + "Title : " + getTitle() + '\n' + "Content : " + getContent() + '\n'
				+ "<<<<<<<<<<<<<" + '\n';
	}
}
