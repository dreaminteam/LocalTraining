package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.Hourse;

public interface HourseDao {

	Hourse getById(int id);

	void insert(Hourse hourse);

	void update(Hourse hourse);

}
