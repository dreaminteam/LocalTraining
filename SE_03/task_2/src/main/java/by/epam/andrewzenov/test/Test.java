package by.epam.andrewzenov.test;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import by.epam.andrewzenov.utils.ResBunUtil;

public class Test {

	public static void main(String[] args) {
		System.out.println("����� ����� (Choice Language). ");
		System.out.println("1 � ������� (Russian language).");
		System.out.println("����� ������ � ���������� (Any symbol - English).");

		Scanner in = new Scanner(System.in);

		String myStr = in.next();

		String baseQuastions = "test";
		String baseAnswers = "answer";

		Locale locale = ResBunUtil.choiceLanguage(myStr);
		System.out.println(locale.toString());

		ResourceBundle quastions = ResBunUtil.getResoursBundle(baseQuastions, locale);
		ResBunUtil.printBundle(quastions);

		ResourceBundle answers = ResBunUtil.getResoursBundle(baseAnswers, locale);

		System.out.print("������� ����� �������(Input number of question): ");

		String key = in.next();

		String ans = ResBunUtil.getBundleValue(answers, key);
		System.out.println(ans);

	}

}
