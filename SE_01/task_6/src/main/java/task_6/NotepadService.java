package task_6;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class NotepadService {

	public static void main(String[] args) {
		NotepadService service = new NotepadService();
		Notepad notepad = service.createNotepad("My first Notepad");

		Record r1 = new Record("1", "my 1-th record");
		Record r2 = new Record("2", "my 2-th record");
		Record r3 = new Record("3", "my 3-th record");
		Record r4 = new Record("4", "my 4-th record");
		Record r5 = new Record("5", "my 5-th record");

		service.addRecord(notepad, r1);
		service.addRecord(notepad, r2);
		service.addRecord(notepad, r3);
		service.addRecord(notepad, r4);
		service.addRecord(notepad, r5);
		service.addRecord(notepad, r1);

		// System.out.println(Arrays.toString(notepad.getRecords()));
		// System.out.println(notepad.getRecords()[0].getTitle().contains("1"));
		// System.out.println(service.getFirstRecordByTitle(notepad, "8"));
		System.out.println(Arrays.toString(service.getRecordByTitle(notepad, "59")));

	}

	public Notepad createNotepad(String name) {
		return new Notepad(name);
	}

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

	public Record getRecordByIndex(Notepad notepad, int index) {
		return notepad.getRecords()[index];
	}

	public Record getFirstRecordByTitle(Notepad notepad, String title) {

		for (Record record : notepad.getRecords()) {
			if (record != null && record.getTitle().contains(title)) {
				return record;
			}
		}
		return null;
	}

	public Record[] getRecordByTitle(Notepad notepad, String title) {
		ArrayList<Record> list = new ArrayList<>();
		for (Record record : notepad.getRecords()) {
			if (record != null && record.getTitle().contains(title)) {
				list.add(record);
			}
		}
		if (list.size() == 0) {
			return null;
		}
		Record[] result = new Record[list.size()];
		result = list.toArray(new Record[list.size()]);
		return result;
	}
	// erunda nije
	public Record[] getRecordByTitle(Notepad notepad, String title, String n) {

		Record[] result = null;
		Stream<Record> stream = Arrays.stream(notepad.getRecords()).filter(p -> p.getTitle().contains(title));
		result = (Record[]) stream.toArray();

		return result;
	}

	public Record[] getAllRecords(Notepad notepad) {
		int length = notepad.getTotalOfRecords();
		Record[] result = new Record[length];
		result = Arrays.copyOf(notepad.getRecords(), length);
		return result;
	}

	public void delRecordFromNotepad(Notepad notepad, int numberOfRecord) {
		notepad.getRecords()[numberOfRecord] = null;
		reindexingAfterDel(notepad.getRecords(), numberOfRecord);
		notepad.setTotalOfRecords(notepad.getTotalOfRecords() - 1);
	}

	private void reindexingAfterDel(Object[] array, int startIndex) {

		for (int i = startIndex; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = null;
	}

	private boolean checkSizeRecords(Notepad notepad) {
		if (notepad.getTotalOfRecords() < notepad.getRecords().length) {
			return true;
		}
		return false;
	}

	private Record[] doublingRecords(Record[] records) {
		return Arrays.copyOf(records, 2 * records.length);
	}

}
