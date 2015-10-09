package task_6;

import java.util.Arrays;

public class NotepadService {

	public static void main(String[] args) {
		NotepadService notepadService = new NotepadService();

		Notepad notepad = notepadService.createNotepad("my notepad");
		notepadService.addRecord(notepad, "1");
		notepadService.addRecord(notepad, "2");
		notepadService.addRecord(notepad, "3");
		notepadService.addRecord(notepad, "4");
		notepadService.addRecord(notepad, "5");
		notepadService.addRecord(notepad, "6");
		notepadService.addRecord(notepad, "7");
		notepadService.addRecord(notepad, "8");
		notepadService.addRecord(notepad, "9");
		notepadService.addRecord(notepad, "10");
		notepadService.updateContentRecordInNotepad(notepad, 0, "newContent");
		notepadService.delRecordFromNotepad(notepad, 0);
		notepadService.printNotepadList(notepad);

	}

	public Notepad createNotepad(String name) {
		return new Notepad(name);
	}

	public void addRecord(Notepad notepad, String titleOfRecord) {
		int numberNextRecord = notepad.getTotalOfRecords();

		if (checkSizeRecords(notepad)) {
			notepad.getRecords()[numberNextRecord] = new Record(titleOfRecord);
		} else {
			notepad.setRecords(doublingRecords(notepad.getRecords()));

			notepad.getRecords()[numberNextRecord] = new Record(titleOfRecord);
		}
		notepad.setTotalOfRecords(numberNextRecord + 1);
	}

	public void addRecord(Notepad notepad, String titleOfRecord, String contentOfRecord) {
		int numberNextRecord = notepad.getTotalOfRecords();

		if (checkSizeRecords(notepad)) {
			notepad.getRecords()[numberNextRecord] = new Record(titleOfRecord, contentOfRecord);
		} else {
			notepad.setRecords(doublingRecords(notepad.getRecords()));

			notepad.getRecords()[numberNextRecord] = new Record(titleOfRecord, contentOfRecord);
		}
		notepad.setTotalOfRecords(numberNextRecord + 1);
	}

	public void updateTitleRecordInNotepad(Notepad notepad, int numberOfRecord, String newTitle) {
		notepad.getRecords()[numberOfRecord].setTitle(newTitle);
	}

	public void updateContentRecordInNotepad(Notepad notepad, int numberOfRecord, String newContent) {
		notepad.getRecords()[numberOfRecord].setContent(newContent);
	}

	public Record delRecordFromNotepad(Notepad notepad, int numberOfRecord) {
		Record record = notepad.getRecords()[numberOfRecord];
		indexation(notepad.getRecords(), numberOfRecord);
		notepad.setTotalOfRecords(notepad.getTotalOfRecords() - 1);
		return record;
	}

	public void printNotepadList(Notepad notepad) {
		System.out.print(notepad.toString());
	}

	private void indexation(Object[] array, int startIndex) {

		for (int i = startIndex; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = null;
	}

	private boolean checkSizeRecords(Notepad notepad) {
		if (notepad.getTotalOfRecords() < notepad.getRecords().length)
			return true;
		return false;

	}

	private Record[] doublingRecords(Record[] records) {
		return Arrays.copyOf(records, 2 * records.length);
	}

}
