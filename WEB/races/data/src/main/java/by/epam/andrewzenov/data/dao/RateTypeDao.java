package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.RateType;

public interface RateTypeDao {

	RateType getById(int id);

	void insert(RateType rateType);

	void update(RateType rateType);

}
