package by.epam.andrewzenov.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DirectoryUtil {

	public static void main(String... args) {
		showDirectory("d:\\downloads\\desktop.inid");
	}

	public static void showDirectory(String pathDirectory) {

		File root = new File(pathDirectory);
		if (root.isFile()) {
			System.out.println(String.format("File %s is not directory.", pathDirectory));
			return;
		}
		File[] list = root.listFiles();
		if (root.isDirectory()) {
			for (File f : list) {
				if (f.isDirectory()) {
					System.err.println("Dir:" + f.getAbsoluteFile());
				} else {
					System.out.println("File:" + f.getAbsoluteFile());
				}
			}
		} else {
			System.out.println("Path is not correct.");
		}
	}

	
	public void createFile(String pathDirectory, String fileName){
		String path=String.format("%s+%s+%s",pathDirectory,File.separator,fileName);
		File file=new File(path);
		try (FileOutputStream fos = new FileOutputStream(file)) {
			if(file.isFile()){
				System.out.println(String.format("File %s is exists. For реплацемент existing file enter 'y'", path));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
