package entities;

public class Pen extends Stationery {

	private String color;

	public Pen(Double cost) {
		setName("Pen");
		setCost(cost);
		this.color = "black";
	}

	public Pen(Double cost, String color) {
		this.color = color;
		setName("Pen");
		setCost(cost);
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Pen [name=" + getName() + ",  cost=" + getCost() + ", color=" + getColor() + "]";
	}

}
