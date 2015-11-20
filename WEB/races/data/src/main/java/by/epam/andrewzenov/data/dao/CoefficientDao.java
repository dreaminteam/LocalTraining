package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.Coefficient;

public interface CoefficientDao {

	Coefficient getById(int id);
	
	void insert(Coefficient coefficient);

	void update(Coefficient coefficient);
	
	
}
