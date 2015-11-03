package task_1.by.epam.andrewzenov.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamUtil {

	public static List<String> getAllWords(byte[] source) {

		List<String> result = new ArrayList<>();

		int from = 0;
		int to = 0;
		final int length = source.length;

		for (int i = 0; i < length; i++) {
			if (!Character.isLetter(source[i])) {
				to = i;
				byte[] newArr = Arrays.copyOfRange(source, from, to);
				result.add(new String(newArr));
				from = i + 1;
			}
		}
		if (Character.isLetter(source[length - 1])) {
			byte[] newArr = Arrays.copyOfRange(source, from, length);
			result.add(new String(newArr));
		}
		return result;
	}

	public static byte[] readFile(String pathName) {

		byte[] result = null;
		try (FileInputStream fin = new FileInputStream(new File(pathName))) {

			result = new byte[fin.available()];
			fin.read(result);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static boolean writeFile(String pathName, byte[] source) {

		boolean result = false;
		try (FileOutputStream out = new FileOutputStream(new File(pathName))) {
			out.write(source);
			result = true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	
}
