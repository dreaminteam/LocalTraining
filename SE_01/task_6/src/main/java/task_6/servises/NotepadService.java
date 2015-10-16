package task_6.servises;

import task_6.entities.Notepad;
import task_6.entities.Record;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Service for working on Notepad
 * 
 * @author AndrewZenov
 * @version JDK_1.8
 *
 */
public class NotepadService {

	public static void main(String[] args) {
	}

	/**
	 * Method for creating new Notepad
	 * 
	 * @param name
	 *            the name of new Notepad
	 * @return Notepad
	 */
	public Notepad createNotepad(String name) {
		return new Notepad(name);
	}

	/**
	 * Adding new Record in Notepad. Uses auxiliary private method
	 * checkSizeRecords(Notepad notepad). Uses auxiliary private method
	 * doublingRecords(Record[] records).
	 * 
	 * @param notepad
	 *            the notepad for adding record
	 * @param record
	 *            the new record
	 */
	public void addRecord(Notepad notepad, Record record) {
		int numberNextRecord = notepad.getTotalOfRecords();

		if (checkSizeRecords(notepad)) {
			notepad.getRecords()[numberNextRecord] = record;
		} else {
			notepad.setRecords(doublingRecords(notepad.getRecords()));

			notepad.getRecords()[numberNextRecord] = record;
		}
		notepad.setTotalOfRecords(numberNextRecord + 1);
	}

	/**
	 * @param notepad
	 *            the Notepad
	 * @param index
	 *            the index for searching Record
	 * @return Record
	 */
	public Record getRecordByIndex(Notepad notepad, int index) {
		return notepad.getRecords()[index];
	}

	/**
	 * Return first Record by title
	 * 
	 * @param notepad
	 *            the Notepad
	 * @param title
	 *            the title for searching
	 * @return Record
	 */
	public Record getFirstRecordByTitle(Notepad notepad, String title) {

		for (Record record : notepad.getRecords()) {
			if (record != null && record.getTitle().contains(title)) {
				return record;
			}
		}
		return null;
	}

	/**
	 * Return all Records by title as array of Records.
	 * 
	 * @param notepad
	 *            the Notepad
	 * @param title
	 *            the title for searching
	 * @return Record[]
	 */
	public Record[] getRecordsByTitle(Notepad notepad, String title) {
		ArrayList<Record> list = new ArrayList<>();
		for (Record record : notepad.getRecords()) {
			if (record != null && record.getTitle().contains(title)) {
				list.add(record);
			}
		}
		Record[] result = list.toArray(new Record[list.size()]);
		return result;
	}

	/**
	 * Return all Records by title as array of Records. Searching by Stream and
	 * filter().
	 * 
	 * @param notepad
	 *            the Notepad
	 * @param title
	 *            the title for searching
	 * @return Record[]
	 */
	public Record[] getRecordsByTitleByStream(Notepad notepad, String title) {
		Record[] result = Arrays.stream(notepad.getRecords(), 0, notepad.getTotalOfRecords())
				.filter(p -> p.getTitle().contains(title)).toArray(Record[]::new);
		return result;
	}

	/**
	 * Return all Records from Notepad as array of Records without null.
	 * 
	 * @param notepad
	 *            the Notepad
	 * @return Record[]
	 */
	public Record[] getAllRecords(Notepad notepad) {
		int length = notepad.getTotalOfRecords();
		Record[] result = new Record[length];
		result = Arrays.copyOf(notepad.getRecords(), length);
		return result;
	}

	/**
	 * Deleting Record from Notepad. Uses auxiliary private method
	 * reIndexingAfterDel(Object[] array, int startIndex)
	 * 
	 * @param notepad
	 *            the Notepad
	 * @param numberOfRecord
	 *            index of record in array with need to delete
	 */
	public void delRecordFromNotepad(Notepad notepad, int numberOfRecord) {
		notepad.getRecords()[numberOfRecord] = null;
		reIndexingAfterDel(notepad.getRecords(), numberOfRecord);
		notepad.setTotalOfRecords(notepad.getTotalOfRecords() - 1);
	}

	/**
	 * Reindexing of array of Record after deleting any Record from Notepad.
	 * Reference of last element of array doing = null
	 * 
	 * @param array
	 *            the array of Objects
	 * @param startIndex
	 *            the start index
	 */
	private void reIndexingAfterDel(Object[] array, int startIndex) {

		for (int i = startIndex; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = null;
	}

	/**
	 * Checking array of Records. If array is not full then return true, else
	 * return false.
	 * 
	 * @param notepad
	 *            the Notepad
	 * @return true or false
	 */
	private boolean checkSizeRecords(Notepad notepad) {
		if (notepad.getTotalOfRecords() < notepad.getRecords().length) {
			return true;
		}
		return false;
	}

	/**
	 * Enlarging array length of Records on 2
	 * 
	 * @param records
	 *            the array of Records
	 * @return Record[]
	 */
	private Record[] doublingRecords(Record[] records) {
		return Arrays.copyOf(records, 2 * records.length);
	}

}
