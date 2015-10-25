package by.epam.andrewzenov.test;

import java.util.ArrayList;

import by.epam.andrewzenov.entities.CrazyLogger;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		CrazyLogger logger = new CrazyLogger("System logs");
		for (int i = 1; i < 11; i++) {
			String str = "My log №" + i;
			logger.addMyLog(str);
			Thread.sleep(100);
		}
		ArrayList<String> list=(ArrayList<String>) logger.searchLogs(25, 10, 2015);

		System.out.println(logger);
		System.out.println(list.toString());

	}

}
