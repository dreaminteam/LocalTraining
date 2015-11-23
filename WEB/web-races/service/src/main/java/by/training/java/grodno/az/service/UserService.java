package by.training.java.grodno.az.service;

import by.training.java.grodno.az.data.model.User;

public interface UserService {

	User get(int id);

	void insert(String login, String password, String first_name, String last_name);

}
