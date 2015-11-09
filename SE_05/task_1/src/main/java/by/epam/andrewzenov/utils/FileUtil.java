package by.epam.andrewzenov.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

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
					System.err.println("Dir:" + f.getName());
				} else {
					System.out.println("File:" + f.getName());
				}
			}
		} else {
			System.out.println("Path is not correct.");
		}
	}

	public static boolean createFile(String path) {
		File file = new File(path);

		if (file.exists()) {
			System.out.println(String.format("File %s is exists. For replacing existing file enter 'y'", path));
			if (!equelsInput('y')) {
				System.out.println("Action canceled.");
				return false;
			}
		}

		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
			System.out.println("File was created.");
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean createDir(String path) {
		File file = new File(path);
		if (file.exists() && file.isDirectory()) {
			System.out.println(String.format("Directory '%s' is exists.", path));
			return false;
		}
		file.mkdirs();
		System.out.println("Directory was created.");
		return true;
	}

	public static boolean appendToFile(String pathName, String textForAppending) {
		String oldFileName = pathName;
		String tmpFileName = pathName + "_tmp";

		File oldFile = new File(oldFileName);

		try (BufferedReader br = new BufferedReader(new FileReader(oldFileName));
				BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFileName));) {

			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line + "\n");
			}
			bw.write(textForAppending);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}

		oldFile.delete();

		File newFile = new File(tmpFileName);
		newFile.renameTo(oldFile);
		return true;

	}

	public static boolean delete(String pathName) {
		File file = new File(pathName);
		if (!file.exists()) {
			System.out.println(String.format("File or directory '%s' not found.", pathName));
			return false;
		}
		if (file.listFiles() == null) {
			file.delete();
			return true;
		}
		System.out.println(
				String.format("Directory '%s' has inner folders or files. For to continue enter 'y'", pathName));
		if (equelsInput('y')) {
			del(file);
			return true;
		}
		System.out.println("Action canceled.");
		return false;
	}

	private static void del(File file) {
		if (file.listFiles() != null) {
			File[] list = file.listFiles();
			for (File f : list) {
				del(f);
			}
		}
		file.delete();
	}

	private static boolean equelsInput(char symbol) {
		try {
			char c = (char) System.in.read();
			if (c == symbol) {
				return true;
			}
			return false;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
