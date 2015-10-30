package be.epam.andrewzenov.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import be.epam.andrewzenov.entities.KeyWord;
import by.epam.andrewzenov.utils.ByteWorkUtil;

public class Test {

	public static void main(String[] args) {

		String pathKeyWords = "keywords.txt";
		String inFile = "input.txt";
		String word = "public";

		byte[] inputArr = ByteWorkUtil.readFileToArrByte(inFile);

		byte[] keyWordArr = ByteWorkUtil.readFileToArrByte(pathKeyWords);

		List<byte[]> listArrOfkeyWord = ByteWorkUtil.getListArrOfByteByRegex(keyWordArr, ',');

		List<KeyWord> listKeyWords = ByteWorkUtil.getListRepeating(inputArr, listArrOfkeyWord);
		for (KeyWord kw : listKeyWords) {
			System.out.println(kw.toString());
		}

	}

	public static String[] readFileToArrString(String pathname, String regex) {

		StringBuilder strBild = new StringBuilder();
		try (Scanner in = new Scanner(new FileReader(new File(pathname)))) {
			while (in.hasNext()) {
				strBild.append(in.nextLine());
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return strBild.toString().split(regex);
	}

}
