package task2.by.epam.andrewzenov.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Test2 {

	public static void main(String[] args) {

		final String pathToRes = ".\\src\\main\\resources\\";
		final String nameFile = "test.properties";

		Properties properties = new Properties();

		try (FileInputStream fin = (new FileInputStream(pathToRes + nameFile))) {
			properties.load(fin);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(properties.toString());
		
		String answ1=properties.getProperty("question_");
		System.out.println(answ1);
	}

}
