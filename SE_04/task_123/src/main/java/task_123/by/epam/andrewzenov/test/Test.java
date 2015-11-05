package task_123.by.epam.andrewzenov.test;

import java.util.List;
import java.util.Map;

import task_123.by.epam.andrewzenov.utils.ReadWriteUtil;
import task_123.by.epam.andrewzenov.utils.SearchUtil;
import task_123.by.epam.andrewzenov.utils.StreamUtil;

public class Test {

	public static void main(String[] args) {

		final String resources="./src/main/resources/";
		final String inFile = resources+"input.txt";
		final String pathKeyWords = resources+"keywords.txt";
		final String outStream = resources+"outStream.txt";

		byte[] sourceByte = StreamUtil.readFile(inFile);
		byte[] keywordsByte = StreamUtil.readFile(pathKeyWords);

		List<String> source = SearchUtil.getAllWords(sourceByte);
		List<String> keywords = SearchUtil.getAllWords(keywordsByte);

		Map<String, Integer> result = SearchUtil.allMatchesToMap(source, keywords);
		System.out.println(StreamUtil.writeFile(outStream, result.toString().getBytes()));

		// task_2

		final String outWrite = resources+"outWrite.txt";

		String sourceStr = ReadWriteUtil.readFile(inFile);
		String keywordsStr = ReadWriteUtil.readFile(pathKeyWords);

		List<String> sourceRead = SearchUtil.getAllWords(sourceStr.getBytes());
		List<String> keywordsRead = SearchUtil.getAllWords(keywordsStr.getBytes());

		Map<String, Integer> resultRead = SearchUtil.allMatchesToMap(sourceRead, keywordsRead);
		System.out.println(ReadWriteUtil.writeFile(outWrite, resultRead.toString()));

		// task_3

		final String fileUTF_8 = resources+"file-utf-8.txt";
		final String fileUTF_16 = resources+"file-utf-16.txt";
		final String cod_utf_8 = "utf-8";
		final String cod_utf_16 = "utf-16";

		System.out.println(ReadWriteUtil.convert(fileUTF_8, fileUTF_16, cod_utf_8, cod_utf_16));

	}

}
