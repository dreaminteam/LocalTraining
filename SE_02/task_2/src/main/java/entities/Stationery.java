package entities;

public class Stationery {

	private int id;
	private String name;
	private double cost;
	private String description;

	public Stationery() {
	}

	public Stationery(int id, String name, Double cost, String description) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}

	public Stationery(String name, Double cost) {
		this.name = name;
		this.cost = cost;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "Stationery [id=" + id + ", name=" + name + ", cost=" + cost + ", description=" + description + "]";
	}

}
