package by.epam.andrewzenov.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CrazyLogger {

	private String name;
	private StringBuilder logs;

	public CrazyLogger(String name) {
		this.name = name;
		logs = new StringBuilder();
	}

	private MyLog createMyLog(String message) {
		return new MyLog(message);
	}

	public void addMyLog(String message) {
		logs.append(createMyLog(message).toString());
	}

	public List<String> searchLogs(int day, int mounth, int year) {
		String forFind = String.format("%s-%s-%s", day, mounth, year);
		List<String> result = new ArrayList<>();
		int start = 0;
		int end = 0;
		boolean flag = true;
		do {
			start = logs.indexOf(forFind, start);
			if (start >= 0) {
				end = logs.indexOf(";", start);
				String subStr = logs.substring(start, end);
				result.add(subStr);
				start = end;
			} else {
				flag = false;
			}
		} while (flag);

		return result;
	}

	@Override
	public String toString() {
		return String.format("Name:%s, Logs:%s", name, logs.toString());
	}

	class MyLog {

		private String message;
		private LocalDateTime date;

		public MyLog(String message) {
			this.message = message;
			this.date = LocalDateTime.now();
		}

		@Override
		public String toString() {
			return String.format("%s-%s-%s:%s-%s-%s;", date.getDayOfMonth(), date.getMonthValue(), date.getYear(),
					date.getHour(), date.getMinute(), message);
		}
	}
}
