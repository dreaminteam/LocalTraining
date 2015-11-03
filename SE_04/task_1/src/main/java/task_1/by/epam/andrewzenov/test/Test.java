package task_1.by.epam.andrewzenov.test;

import java.util.List;

import task_1.by.epam.andrewzenov.entities.KeyWord;
import task_1.by.epam.andrewzenov.utils.ReadWriteUtil;
import task_1.by.epam.andrewzenov.utils.SearchUtil;
import task_1.by.epam.andrewzenov.utils.StreamUtil;

public class Test {

	public static void main(String[] args) {

		String pathKeyWords = "keywords.txt";
		String inFile = "input.txt";
		String outStream="outStream.txt";
		String outWrite="outWrite.txt";

		byte[] sourceByte = StreamUtil.readFile(inFile);
		byte[] keywordsByte = StreamUtil.readFile(pathKeyWords);

		List<String> source = StreamUtil.getAllWords(sourceByte);
		List<String> keywords = StreamUtil.getAllWords(keywordsByte);

		List<KeyWord> result=SearchUtil.allMatches(source, keywords);
		System.out.println(result);
		
		StreamUtil.writeFile(outStream, result.toString().getBytes());
		
		//task_2
		
		String sourceStr=ReadWriteUtil.readFile(inFile);
		String keywordsStr=ReadWriteUtil.readFile(pathKeyWords);
		
		List<String> sourceRead=StreamUtil.getAllWords(sourceStr.getBytes());
		List<String> keywordsRead=StreamUtil.getAllWords(keywordsStr.getBytes());
		
		List<KeyWord> resultRead=SearchUtil.allMatches(sourceRead, keywordsRead);
		System.out.println(resultRead);
		
		ReadWriteUtil.writeFile(outWrite, resultRead.toString());

	}

	
}
