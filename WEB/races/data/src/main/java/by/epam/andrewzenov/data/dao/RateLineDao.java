package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.RateLine;

public interface RateLineDao {

	RateLine getById(int id);

	void insert(RateLine rateLine);

	void update(RateLine rateLine);

}
