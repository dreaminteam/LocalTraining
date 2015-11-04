package task_1.by.epam.andrewzenov.test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import task_1.by.epam.andrewzenov.utils.ReadWriteUtil;
import task_1.by.epam.andrewzenov.utils.SearchUtil;
import task_1.by.epam.andrewzenov.utils.StreamUtil;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {

		/*
		 * final String pathKeyWords = "keywords.txt"; final String inFile =
		 * "input.txt"; final String outStream = "outStream.txt";
		 * 
		 * byte[] sourceByte = StreamUtil.readFile(inFile); byte[] keywordsByte
		 * = StreamUtil.readFile(pathKeyWords);
		 * 
		 * List<String> source = StreamUtil.getAllWords(sourceByte);
		 * List<String> keywords = StreamUtil.getAllWords(keywordsByte);
		 * 
		 * List<String> result = SearchUtil.allMatches(source, keywords);
		 * System.out.println(result);
		 * 
		 * StreamUtil.writeFile(outStream, result.toString().getBytes());
		 * 
		 * // task_2
		 * 
		 * final String outWrite = "outWrite.txt";
		 * 
		 * String sourceStr = ReadWriteUtil.readFile(inFile); String keywordsStr
		 * = ReadWriteUtil.readFile(pathKeyWords);
		 * 
		 * List<String> sourceRead =
		 * StreamUtil.getAllWords(sourceStr.getBytes()); List<String>
		 * keywordsRead = StreamUtil.getAllWords(keywordsStr.getBytes());
		 * 
		 * Map<String, Integer> resultRead =
		 * SearchUtil.allMatchesToMap(keywordsRead, sourceRead);
		 * System.out.println(resultRead);
		 * 
		 * ReadWriteUtil.writeFile(outWrite, resultRead.toString());
		 */

		// task_3

		final String pathUTF_8 = "file-utf-8.txt";
		final String pathUTF_16 = "file-utf-16.txt";
		final String cod_utf_8 = "utf-8";
		final String cod_utf_16 = "utf-16";

		byte[] inputUTF_8 = ReadWriteUtil.readFile(pathUTF_8, cod_utf_8);
		System.out.println(Arrays.toString(inputUTF_8));
		String out=new String(inputUTF_8, cod_utf_16);
		System.out.println(out);
		System.out.println(ReadWriteUtil.writeFile(pathUTF_16, inputUTF_8, cod_utf_16));

		
		
		
/*		String s = "G";
		byte[] s1251 = s.getBytes();
		byte[] s8 = s.getBytes("UTF-8");
		byte[] s16 = s.getBytes("UTF-16");
		System.out.println(Arrays.toString(s1251));
		System.out.println(Arrays.toString(s8));
		System.out.println(Arrays.toString(s16));*/

	}

}
