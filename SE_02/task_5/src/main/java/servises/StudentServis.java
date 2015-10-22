package servises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import entities.Course;
import entities.GroupOfStudents;
import entities.JournalOfGroup;
import entities.StudMark;
import entities.Student;
import entities.Subject;

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

	public <E extends Number> void addMarkOfStudent(GroupOfStudents<Subject> group, Student student, E mark) {
		if (!group.getSubject().isInt()) {
			student.setMark((Double)mark);
			return;
		}
		student.setMark((Integer) mark);
		return;
	}

	public void sortAllMarkOfStudentInc(Student student, Course course){
		allMarkOfStudent(student, course).sort((o1,o2)->o1.getMark()-o2.getMark());
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
