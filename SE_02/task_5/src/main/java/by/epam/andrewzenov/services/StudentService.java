package by.epam.andrewzenov.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.epam.andrewzenov.entities.Course;
import by.epam.andrewzenov.entities.GroupOfStudents;
import by.epam.andrewzenov.entities.StudMark;
import by.epam.andrewzenov.entities.Student;
import by.epam.andrewzenov.subjects.Subject;

public class StudentService {

	public Student createStudent(String name, String surName, int numOfIdCard) {
		return new Student(name, surName, numOfIdCard);
	}

	public Boolean hasGroupStudent(Student student, GroupOfStudents group) {
		Optional<Student> result = group.getListOfStudent().stream().filter(Student -> Student.equals(student))
				.findFirst();
		if (result.isPresent()) {
			return true;
		}
		return false;
	}

	public <T extends Number> StudMark createStudMark(Student student, Subject<T> subject, T mark) {
		return new StudMark(student, subject, mark);
	}

	public void sortMarkOfStudentInc(List<StudMark> list) {
		list.sort((o1, o2) -> o1.compareTo(o2));
	}

	public void sortMarkOfStudentDec(List<StudMark> list) {
		list.sort((o1, o2) -> o1.compareTo(o2));
	}

	public StudMark getStudMarkOfGroup(Student student, GroupOfStudents group) {

		Optional<StudMark> result = group.getListStudMarkOfGroup().stream()
				.filter(StudMark -> StudMark.getStudent().equals(student)).findFirst();
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}

	public List<StudMark> allMarkOfStudent(Student student, Course course) {
		List<StudMark> result = new ArrayList<>();
		for (GroupOfStudents c : course.getListGroupsOfCourse()) {
			if (hasGroupStudent(student, c)) {
				StudMark sMark = getStudMarkOfGroup(student, c);
				if (sMark != null) {
					result.add(sMark);
				}
			}
		}
		return result;
	}

}
