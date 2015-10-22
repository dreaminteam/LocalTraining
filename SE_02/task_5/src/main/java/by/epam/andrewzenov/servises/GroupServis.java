package by.epam.andrewzenov.servises;

import java.util.Optional;

import by.epam.andrewzenov.entities.Course;
import by.epam.andrewzenov.entities.GroupOfStudents;
import by.epam.andrewzenov.entities.Student;
import by.epam.andrewzenov.entities.Subject;

public class GroupServis {

	public GroupOfStudents createGroup(T<E> subject, String name, Course course) {
		GroupOfStudents<Subject> group = new GroupOfStudents<Subject>(subject, name);
		course.getListGroupsOfCourse().add(group);
		return group;
	}

	public void addStudentToGroup(GroupOfStudents<Subject> group, Student student) {
		group.getListOfStudent().add(student);
	}

}
