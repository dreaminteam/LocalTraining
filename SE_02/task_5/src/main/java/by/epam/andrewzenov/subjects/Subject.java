package by.epam.andrewzenov.subjects;

import java.lang.reflect.Type;

public class Subject<T extends Number> {

	public Subject(Class gen) {
		T = gen;
	}

	Class T;


	public static void main(String[] args) {
		Subject<Double> s =new Subject<>(T5);
		System.out.println(s.getT());
	}

}
