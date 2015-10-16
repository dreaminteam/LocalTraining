package task_6.entities;

import java.util.Arrays;

/**
 * @author AndrewZenov
 * @version JDK_1.8 This class description entity Notepad. Notepad has
 *          properties name, array of Record and counter of Records in Notepad.
 */
public class Notepad {

	private String name;
	private Record[] records;
	private int totalOfRecords;

	/**
	 * Default Record[].length=10. Quantity of Records = 0;
	 * 
	 * @param name
	 *            the name of Notepad
	 */
	public Notepad(String name) {
		this.name = name;
		this.setRecords(new Record[10]);
		this.totalOfRecords = 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return quantity of records
	 * 
	 * @return the totalOfRecords
	 */
	public int getTotalOfRecords() {
		return totalOfRecords;
	}

	/**
	 * @param totalOfRecords
	 *            the totalOfRecords to set
	 */
	public void setTotalOfRecords(int totalOfRecords) {
		this.totalOfRecords = totalOfRecords;
	}

	/**
	 * @return the records
	 */
	public Record[] getRecords() {
		return records;
	}

	/**
	 * @param records
	 *            the records to set
	 */
	public void setRecords(Record[] records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "Notepad's name:" + name + '\n' + Arrays.toString(records);
	}

}
