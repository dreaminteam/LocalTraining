package by.epam.andrewzenov.test;

import by.epam.andrewzenov.entities.PropertySource;

public class Test {

	public static void main(String[] args) {

		final String path = ".\\src\\main\\resources\\test.properties";
		final String key = "question_1";

		PropertySource pSource = new PropertySource(path);

		pSource.showAll();

		String value = pSource.getProperty(key);
		System.out.println(value);

	}

}
