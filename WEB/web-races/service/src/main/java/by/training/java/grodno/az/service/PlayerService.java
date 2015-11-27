package by.training.java.grodno.az.service;

import by.training.java.grodno.az.data.model.Player;
import by.training.java.grodno.az.data.model.User;

public interface PlayerService extends IService<Player> {

	User getUser(int user_id);
	
}
