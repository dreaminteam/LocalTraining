package task2.by.epam.andrewzenov.entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertySource {

	private Properties properties;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		PropertySource prop = new PropertySource("ddf");
		System.out.println(prop.toString());
	}

	public PropertySource(String path) throws FileNotFoundException, IOException {
		properties = new Properties();
		try (FileInputStream fin = (new FileInputStream(path))) {
			properties.load(fin);
		}
	}

}
