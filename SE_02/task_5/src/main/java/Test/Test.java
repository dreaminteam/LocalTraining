package Test;

import java.util.ArrayList;
import java.util.List;

import entities.GroupOfStudents;
import entities.Student;
import entities.Subject;
import servises.GroupServis;

public class Test {

	public static void main(String[] args) {

		GroupServis groupServis = new GroupServis();

		Student st1 = new Student("A", "B", 22);
		Student st2 = new Student("A", "C", 20);

		List<Student> list = new ArrayList<>();
		list.add(st1);
		list.add(st2);

		GroupOfStudents<Subject> group = groupServis.createGroup(Subject.ALGEBRA, "MMF2010");

	}

}
