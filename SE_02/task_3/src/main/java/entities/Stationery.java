package entities;

public abstract class Stationery {

	private String name;
	private Double cost;

	Stationery(Double cost) {
		setName(getClass().getName());
		setCost(cost);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "[name:" + getName() + ", cost:" + getCost() + "]";
	}

}
