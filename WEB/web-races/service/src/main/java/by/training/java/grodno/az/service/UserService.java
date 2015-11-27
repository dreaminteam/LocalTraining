package by.training.java.grodno.az.service;

import by.training.java.grodno.az.data.model.User;

public interface UserService extends IService<User> {

	String encryption(String source);

	public User getByLogPas(String login, String password);

}
