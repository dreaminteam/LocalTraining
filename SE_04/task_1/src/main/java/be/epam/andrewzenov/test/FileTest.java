package be.epam.andrewzenov.test;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {

		File fp = new File("FileTest2.java");

		if (fp.exists()) {
			System.out.println(fp.getName() + " exists");
			if (fp.isFile()) {
				System.out.println("Path to file:\t" + fp.getPath());
				System.out.println("Absolut Path to file:\t" + fp.getAbsolutePath());
				System.out.println("Size of file:\t" + fp.length());
				System.out.println("Lost modification of file:\t" + fp.lastModified());
				System.out.println("File can read:\t" + fp.canRead());
				System.out.println("File can write:\t" + fp.canWrite());
				//System.out.println("File deleted:\t" + fp.delete());
			}
		}

		else {
			System.out.println("File " + fp.getName() + " not exists");
			try {
				fp.createNewFile();
			} catch (IOException e) {

			}
		}
	}

}
