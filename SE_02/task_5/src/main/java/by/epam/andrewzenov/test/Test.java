package by.epam.andrewzenov.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.epam.andrewzenov.entities.Course;
import by.epam.andrewzenov.entities.GroupOfStudents;
import by.epam.andrewzenov.entities.StudMark;
import by.epam.andrewzenov.entities.Student;
import by.epam.andrewzenov.servises.GroupServis;
import by.epam.andrewzenov.servises.StudentServis;
import by.epam.andrewzenov.subjects.Algebra;
import by.epam.andrewzenov.subjects.Mechanics;
import by.epam.andrewzenov.subjects.Philosophy;

public class Test {

	public static void main(String[] args) {

		Algebra algebra = new Algebra();
		Mechanics mechanics = new Mechanics();
		Philosophy philosophy=new Philosophy();

		Student stud1 = new Student("Name_1", "Surname_1", 0001);
		Student stud2 = new Student("Name_2", "Surname_2", 0002);
		Student stud3 = new Student("Name_3", "Surname_3", 0003);
		Student stud4 = new Student("Name_4", "Surname_4", 0004);
		Student stud5 = new Student("Name_5", "Surname_5", 0005);
		Student stud6 = new Student("Name_6", "Surname_6", 0006);

		List<Student> listOfStudents = new ArrayList<>();
		listOfStudents.add(stud1);
		listOfStudents.add(stud2);
		listOfStudents.add(stud3);
		listOfStudents.add(stud4);
		listOfStudents.add(stud5);
		listOfStudents.add(stud6);

		List<Student> listOfStudents_2 = new ArrayList<>();
		listOfStudents_2.add(stud1);
		listOfStudents_2.add(stud2);
		listOfStudents_2.add(stud3);
		listOfStudents_2.add(stud4);
		listOfStudents_2.add(stud5);
		
		GroupServis groupServis = new GroupServis();
		GroupOfStudents groupMech = groupServis.createGroup("Mechanics", mechanics);
		GroupOfStudents groupAlg = groupServis.createGroup("Algebra", algebra);
		GroupOfStudents groupPhil = groupServis.createGroup("Philosophy", philosophy);
		
		groupServis.setListOfStudents(groupMech, listOfStudents);
		groupServis.setListOfStudents(groupAlg, listOfStudents);
		groupServis.setListOfStudents(groupPhil, listOfStudents_2);

		Course course = new Course("1 kurs");
		course.getListGroupsOfCourse().add(groupMech);
		course.getListGroupsOfCourse().add(groupAlg);
		course.getListGroupsOfCourse().add(groupPhil);

		StudentServis studentServis = new StudentServis();
		System.out.println(studentServis.addStudMarkToGroup(stud6, groupAlg, algebra, 7.0));
		System.out.println(studentServis.addStudMarkToGroup(stud6, groupMech, mechanics, 9));
		System.out.println(studentServis.addStudMarkToGroup(stud6, groupPhil, philosophy, 6.4));
		
		List<StudMark> marksOfstud6=studentServis.allMarkOfStudent(stud6, course);
		System.out.println(marksOfstud6.toString());
		studentServis.sortMarkOfStudentDec(marksOfstud6);
		System.out.println(marksOfstud6.toString());
		
		List<StudMark> marksOfstud1=studentServis.allMarkOfStudent(stud1, course);
		System.out.println(marksOfstud1.toString());
	}

}
