package by.epam.andrewzenov.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import be.epam.andrewzenov.entities.KeyWord;

public class ByteWorkUtil {

	public static List<KeyWord> getListRepeating(byte[] source, List<byte[]> checkWords) {
		List<KeyWord> result = new ArrayList<>();
		for (byte[] b : checkWords) {
			int quantity = searchArrByte(source, b);
			if (quantity > 0) {
				KeyWord keyWord = new KeyWord(new String(b), quantity);
				result.add(keyWord);
			}
		}
		return result;
	}

	public static List<byte[]> getListArrOfByteByRegex(byte[] arrOfByte, char regex) {
		List<byte[]> result = new ArrayList<>();

		int from = 0;
		int to = 0;
		int length = arrOfByte.length;
		for (int i = 0; i < length; i++) {
			if (arrOfByte[i] == regex) {
				to = i;
				byte[] newArr = Arrays.copyOfRange(arrOfByte, from, to);
				result.add(newArr);
				from = i + 1;
			}
		}
		if (arrOfByte[length - 1] != regex) {
			byte[] newArr = Arrays.copyOfRange(arrOfByte, from, length);
			result.add(newArr);
		}
		return result;
	}

	public static byte[] readFileToArrByte(String pathName) {

		byte[] result = null;
		try (FileInputStream fin = new FileInputStream(new File(pathName))) {

			result = new byte[fin.available()];
			fin.read(result);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;

	}

	public static boolean equelsArrByte(byte[] arrA, byte[] arrB) {
		if (arrA.length != arrB.length) {
			return false;
		}
		for (int i = 0; i < arrA.length; i++) {
			if (arrA[i] != arrB[i]) {
				return false;
			}
		}
		return true;
	}

	public static int searchArrByte(byte[] source, byte[] searching) {

		int result = 0;
		int end = source.length - searching.length;
		int j = 0;

		for (int i = 0; i <= end; i++) {
			boolean flag = false;
			if (source[i] == searching[j]) {
				flag = true;
				j++;
				for (int q = i + 1; q < i + searching.length; q++) {
					if (source[q] == searching[j]) {
						j++;
					} else {
						flag = false;
						j = 0;
						i = q + 1;
						break;
					}

				}
				if (flag) {

					flag = isNearNotLetterOrDigit(source, searching, i) ? true : false;
				}
			}
			j = 0;
			if (flag) {
				result++;
			}
		}
		return result;
	}

	private static boolean isNearNotLetterOrDigit(byte[] source, byte[] searching, int startIndexSearchInSource) {

		int index = startIndexSearchInSource;
		int before = index - 1;
		int after = index + searching.length;

		if (before >= 0) {
			if (Character.isLetter(source[before]) || Character.isDigit(source[before])) {
				return false;
			}
		}

		if (after < source.length) {
			if (Character.isLetter(source[after]) || Character.isDigit(source[after])) {
				return false;
			}
		}
		return true;
	}
}
