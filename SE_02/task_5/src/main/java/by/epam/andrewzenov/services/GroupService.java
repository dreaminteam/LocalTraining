package by.epam.andrewzenov.services;

import java.util.List;

import by.epam.andrewzenov.entities.GroupOfStudents;
import by.epam.andrewzenov.entities.StudMark;
import by.epam.andrewzenov.entities.Student;
import by.epam.andrewzenov.subjects.Subject;

public class GroupService {

	public GroupOfStudents createGroup(String name, Subject subject) {
		return new GroupOfStudents(name, subject);
	}

	public void addStudentToGroup(GroupOfStudents group, Student student) {
		group.getListOfStudent().add(student);
	}

	public List<Student> getListOfStudents(GroupOfStudents group) {
		return group.getListOfStudent();
	}

	public void setListOfStudents(GroupOfStudents group, List<Student> list) {
		group.setListOfStudent(list);
	}
	
	public boolean addStudMarkToGroup( GroupOfStudents group, StudMark studMark) {
		if (group.getSubject().getClazz() != studMark.getSubject().getClazz()) {
			return false;
		} 
		
		if (!new StudentService().hasGroupStudent(studMark.getStudent(), group)) {
			return false;
		}
		group.getListStudMarkOfGroup().add(studMark);
		return true;
	}

}
