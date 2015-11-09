package task2.by.epam.andrewzenov.entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertySource {

	private Properties properties;

	public PropertySource(String path) {
		properties = new Properties();
		try (FileInputStream fin = (new FileInputStream(path))) {
			properties.load(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		if (!properties.containsKey(key)) {
			throw new IllegalArgumentException(String.format("%s not found.", key));
		}
		return properties.getProperty(key);
	}

}
