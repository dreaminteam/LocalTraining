package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.User;

public interface UserDao {

	User getById(int id);

	void insert(User user);

	void update(User user);

}
