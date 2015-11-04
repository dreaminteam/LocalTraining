package task_1.by.epam.andrewzenov.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ReadWriteUtil {

	public static String readFile(String pathName) {

		StringBuilder result = new StringBuilder();
		String str;
		try (BufferedReader buf = new BufferedReader(new FileReader(new File(pathName)))) {
			while ((str = buf.readLine()) != null) {
				result.append(str);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result.toString();
	}

	public static byte[] readFile(String patnName, String charsetName) {
		byte[] result = null;
		try (BufferedReader buf = new BufferedReader(new FileReader(new File(patnName)))) {
			result = buf.readLine().getBytes(charsetName);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static boolean writeFile(String pathName, String source) {

		boolean result = false;

		try (FileWriter out = new FileWriter(new File(pathName))) {
			out.write(source);
			result = true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static boolean writeFile(String pathName, byte[] source, String charsetName) {

		boolean result = false;

		try (OutputStream outputStream = new FileOutputStream(new File(pathName));
				Writer outputStreamWriter = new OutputStreamWriter(outputStream, charsetName);) {
			outputStream.write(source);
			result = true;
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
