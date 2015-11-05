package task_123.by.epam.andrewzenov.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamUtil {

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
