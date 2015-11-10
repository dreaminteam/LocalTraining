package by.epam.andrewzenov.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PropertySource {

	private Map<String, String> mapProp;

	public PropertySource(String path) {
		mapProp = new HashMap<>();
		String str;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while ((str = br.readLine()) != null) {
				initMap(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAll() {
		for (Map.Entry<String, String> entry : mapProp.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(String.format("%s:%s", key, value));
		}
	}

	public String getProperty(String key) {
		if (!mapProp.containsKey(key)) {
			throw new IllegalArgumentException(String.format("Key '%s' not found.", key));
		}
		return mapProp.get(key);
	}

	private void initMap(String str) {
		String key;
		String value;
		int index;
		index = str.indexOf('=');
		key = str.substring(0, index);
		value = str.substring(index + 1, str.length());
		mapProp.put(key, value);
	}

}
