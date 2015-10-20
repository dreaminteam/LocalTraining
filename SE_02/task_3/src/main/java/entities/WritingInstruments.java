package entities;

public abstract class WritingInstruments extends Stationery {

	private String color;

	public WritingInstruments(Double cost) {
		super(cost);
		setColor("black");
	}

	public WritingInstruments(Double cost, String color) {
		super(cost);
		setColor(color);
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[name:" + getName() + ", cost:" + getCost() + ", color:" + getColor() + "]";
	}

}
