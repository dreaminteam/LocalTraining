package task_6;

import java.time.LocalDate;

public class Record {

	private LocalDate dateCreateRecord;
	private LocalDate lastChangeRecord;
	private String content;
	private String title;

	public static void main(String[] args) {
		Record record = new Record("title", "content");
		System.out.println(record.toString());
	}

	public Record(String title) {
		this.title = title;
		this.dateCreateRecord = LocalDate.now();
		this.lastChangeRecord = this.dateCreateRecord;
		this.content = "";
	}

	public Record(String title, String content) {
		this.title = title;
		this.dateCreateRecord = LocalDate.now();
		this.lastChangeRecord = this.dateCreateRecord;
		this.content = content;
	}

	/**
	 * @return the dateCreateRecord
	 */
	public LocalDate getDateCreateRecord() {
		return dateCreateRecord;
	}

	/**
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
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
		this.lastChangeRecord = LocalDate.now();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
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
