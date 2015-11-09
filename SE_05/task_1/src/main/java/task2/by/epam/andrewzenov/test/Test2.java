package task2.by.epam.andrewzenov.test;

import task2.by.epam.andrewzenov.entities.PropertySource;

public class Test2 {

	public static void main(String[] args) {

		final String path = ".\\src\\main\\resources\\test.properties";
		final String key = "question_1";

		PropertySource pSource = new PropertySource(path);

		String value1 = pSource.getProperty(key);
		System.out.println(value1);

	}

}
