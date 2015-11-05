package task_123.by.epam.andrewzenov.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchUtil {

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

	public static Map<String, Integer> allMatchesToMap(List<String> sourceWords, List<String> keywords) {

		Map<String, Integer> keywordsCount = new HashMap<>();
		keywords.stream().forEach(e -> keywordsCount.put(e, 0));
		sourceWords.stream().filter(word -> keywordsCount.get(word) != null)
				.forEach(word -> keywordsCount.put(word, keywordsCount.get(word) + 1));
		return keywordsCount;
	}

}
