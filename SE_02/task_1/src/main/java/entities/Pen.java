package entities;

public class Pen extends Stationery {

	private String color;

	public Pen() {
	}

	public Pen(Double cost) {
		setName("Pen");
		setCost(cost);
		setDescription("This is Pen");
	}

	public Pen(Double cost, String color) {
		this.color = color;
		setName("Pen");
		setCost(cost);
		setDescription("This is " + color + " Pen");
	}

	public static void main(String[] args) {

		Pen pen1 = new Pen();
		Pen pen2 = new Pen(1.5);
		Pen pen3 = new Pen(1.5, "red");
		System.out.println(pen1.toString());
		System.out.println(pen2.toString());
		System.out.println(pen3.toString());
		pen1.setDescription("new description");
		System.out.println(pen1.hashCode());
		System.out.println(pen2.hashCode());
		System.out.println(pen3.hashCode());
		System.out.println(pen3.equals(pen2));

	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode of Pen");
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equels of Pen");
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pen [name=" + getName() + ",  cost=" + getCost() + ", description=" + getDescription() + "]";
	}

}
