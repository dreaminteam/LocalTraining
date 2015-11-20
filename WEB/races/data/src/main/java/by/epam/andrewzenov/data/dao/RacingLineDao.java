package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.RacingLine;

public interface RacingLineDao {

	RacingLine getById(int id);

	void insert(RacingLine racingLine);

	void update(RacingLine racingLine);

}
