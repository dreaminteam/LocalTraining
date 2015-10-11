package task_6;

public class RecordService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Record createRecord(String title) {
		return new Record(title);
	}

	public Record createRecord(String title, String content) {
		return new Record(title, content);
		
	}

	public void changeTitle(Record record, String newTitle) {
		record.setTitle(newTitle);
	}

	public void updateRecord(Record record, String newContent) {
		record.setContent(newContent);
	}

}
