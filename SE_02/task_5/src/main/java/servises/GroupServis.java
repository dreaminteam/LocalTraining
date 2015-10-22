package servises;

import java.util.Optional;

import entities.Course;
import entities.GroupOfStudents;
import entities.Student;
import entities.Subject;

public class GroupServis {

	public GroupOfStudents<Subject> createGroup(Subject subject, String name, Course course) {
		GroupOfStudents<Subject> group = new GroupOfStudents<Subject>(subject, name);
		course.getListGroupsOfCourse().add(group);
		return group;
	}

	public void addStudentToGroup(GroupOfStudents<Subject> group, Student student) {
		group.getListOfStudent().add(student);
	}

}
