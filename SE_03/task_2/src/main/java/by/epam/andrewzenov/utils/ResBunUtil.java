package by.epam.andrewzenov.utils;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResBunUtil {

	public static Locale choiceLanguage(String str) {

		if (str.equals("1")) {

			return new Locale("RU", "RU");
		}
		return new Locale("");
	}

	public static ResourceBundle getResoursBundle(String baseName, Locale locale) {
		return ResourceBundle.getBundle(baseName, locale);
	}

	public static void printBundle(ResourceBundle bundle) {
		ResourceBundle rb = bundle;
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key + " : " + rb.getString(key));
		}
	}

	public static String getBundleValue(ResourceBundle bundle, String key) {
		try {
			return bundle.getString(key);
		} catch (MissingResourceException re) {
			System.out.println("Value not found. Key '" + key + "' is not correct.");
			return null;
		}
	}

}
