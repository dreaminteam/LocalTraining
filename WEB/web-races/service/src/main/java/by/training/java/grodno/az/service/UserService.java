package by.training.java.grodno.az.service;

import by.training.java.grodno.az.data.model.User;

public interface UserService {

	User get(int id);

	int insert(User u);

	void update(User user);

}
