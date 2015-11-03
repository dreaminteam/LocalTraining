package task_1.by.epam.andrewzenov.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import task_1.by.epam.andrewzenov.entities.KeyWord;

public class SearchUtil {

	public static List<KeyWord> allMatches(List<String> source, List<String> listOfSearch) {
		List<KeyWord> result = new ArrayList<>();
		for (String t : listOfSearch) {
			int quantity = matches(source, t);
			if (quantity > 0) {
				result.add(new KeyWord(t, quantity));
			}
		}
		return result;
	}

	public static int matches(List<String> source, String search) {
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

}
