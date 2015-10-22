package by.epam.andrewzenov.servises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import by.epam.andrewzenov.entities.Course;
import by.epam.andrewzenov.entities.GroupOfStudents;
import by.epam.andrewzenov.entities.JournalOfGroup;
import by.epam.andrewzenov.entities.StudMark;
import by.epam.andrewzenov.entities.Student;
import by.epam.andrewzenov.entities.Subject;

public class StudentServis {

	public Student createStudent(String name, String surName, int numOfIdCard) {
		return new Student(name, surName, numOfIdCard);
	}

	public <T extends Subject> Boolean hasGroupStudent(Student student, GroupOfStudents<T> group) {
		Optional<Student> result = group.getListOfStudent().stream().filter(Student -> Student.equals(student))
				.findFirst();
		if (result.isPresent()) {
			return true;
		}
		return false;
	}

	public void sortAllMarkOfStudentInc(Student student, Course course) {
		allMarkOfStudent(student, course).sort((o1, o2) -> o1.getMark().doubleValue() - o2.getMark().doubleValue());
	}

	public StudMark getStudMark(Student student, JournalOfGroup journal) {
		Optional<StudMark> result = journal.getListOfStudMark().stream()
				.filter(StudMark -> StudMark.getStudent().equals(student)).findFirst();
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}

	public List<StudMark> allMarkOfStudent(Student student, Course course) {
		List<StudMark> result = new ArrayList<>();
		for (GroupOfStudents<Subject> c : course.getListGroupsOfCourse()) {
			if (hasGroupStudent(student, c)) {
				StudMark sMark = getStudMark(student, c.getJournalOfStudMark());
				if (sMark != null) {
					result.add(sMark);
				}
			}
		}
		return result;
	}

}
