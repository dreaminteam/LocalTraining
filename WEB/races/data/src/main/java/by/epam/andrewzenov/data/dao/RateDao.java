package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.Rate;

public interface RateDao {

	Rate getById(int id);

	void insert(Rate rate);

	void update(Rate rate);

}
