package Test;

import java.util.ArrayList;
import java.util.List;

import entities.GroupOfStudents;
import entities.Student;
import entities.Subject;

public class Test {

	public static void main(String[] args) {

		Student st1 = new Student("A", "B", 22);
		Student st2 = new Student("A", "C", 20);

		List<Student> list = new ArrayList<>();
		list.add(st1);
		list.add(st2);

		GroupOfStudents<Subject> group = new GroupOfStudents<>(Subject.ALGEBRA, "best");
		group.setList(list);
		
	}

}
