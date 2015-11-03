package task_1.by.epam.andrewzenov.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteUtil {

	public static String readFile(String pathName) {

		StringBuilder result = new StringBuilder();
		String str;
		try (BufferedReader buf = new BufferedReader(new FileReader(new File(pathName)))) {
						while((str=buf.readLine())!=null){
							result.append(str);
						}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result.toString();
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

	
}
