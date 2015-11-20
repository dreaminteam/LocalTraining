package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.Participant;

public interface ParticipantDao {

	Participant getById(int id);

	void insert(Participant participant);

	void update(Participant participant);

}
