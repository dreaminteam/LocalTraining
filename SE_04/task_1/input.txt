package task_1.by.epam.andrewzenov.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchUtil {

	public static List<String> allMatches(List<String> source, List<String> listOfSearch) {
		List<String> result = new ArrayList<>();
		for (String t : listOfSearch) {
			int quantity = quantityMatches(source, t);
			if (quantity > 0) {
				result.add(String.format("%s(%s)", t,quantity));
			}
		}
		return result;
	}

	public static int quantityMatches(List<String> source, String search) {
		int result = 0;
		int indexSublist = 0;
		List<String> in = source;
		while (indexSublist != -1) {
			indexSublist = Collections.indexOfSubList(in, Arrays.asList(search));
			if (indexSublist != -1) {
				in = in.subList(indexSublist + 1, in.size());
				result++;
			}
		}
		return result;
	}
	
	public static Map<String, Integer> allMatchesToMap(List<String> keywords2, List<String> sourceWords) {
		
		Map<String, Integer> keywordsCount = new HashMap<>();
		keywords2.stream().forEach(e -> keywordsCount.put(e, 0));
		sourceWords.stream().filter(word -> keywordsCount.get(word) != null)
				.forEach(word -> keywordsCount.put(word, keywordsCount.get(word) + 1));
		return keywordsCount;
	}

}
