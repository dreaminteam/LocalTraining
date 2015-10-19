package services;

import entities.Stationery;

public class StationeryServes {

	public Stationery createStationery(String name, double cost) {
		return new Stationery(name, cost);
	}

	public Stationery createStationery(int id, String name, double cost, String description) {
		return new Stationery(id, name, cost, description);
	}

}
