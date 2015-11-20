package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.Jockey;

public interface JockeyDao {

	Jockey getById(int id);

	void insert(Jockey jockey);

	void update(Jockey jockey);

}
