package task_6;

import java.util.Arrays;

public class Notepad {

	private String name;
	private Record[] records;
	private int totalOfRecords;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Notepad(String name) {
		this.name = name;
		this.setRecords(new Record[10]);
		this.totalOfRecords = 0;
	}
	
	@Override
	public String toString(){
		return "Notepad's name:"+name+'\n'+Arrays.toString(records);
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
	 * @param records the records to set
	 */
	public void setRecords(Record[] records) {
		this.records = records;
	}

}
