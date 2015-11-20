package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.HourseRacing;

public interface HourseRacingDao {

	HourseRacing getById(int id);

	void insert(HourseRacing hourseRacing);

	void update(HourseRacing hourseRacing);

}
