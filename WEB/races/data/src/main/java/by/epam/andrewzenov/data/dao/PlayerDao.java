package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.Player;

public interface PlayerDao {

	Player getById(int id);

	void insert(Player player);

	void update(Player player);

}
