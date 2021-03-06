package entities;

public abstract class Stationery {

	private String name;
	private Double cost;
	private String description;

	Stationery() {
		name = "abstract stationery";
		cost = 0.0;
		description = "This is abstract stationery ";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode of abstract Stationery");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equels of abstract Stationery");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stationery other = (Stationery) obj;
		if (getCost() == null) {
			if (other.getCost() != null)
				return false;
		} else if (!getCost().equals(other.getCost()))
			return false;
		if (getDescription() == null) {
			if (other.getDescription() != null)
				return false;
		} else if (!getDescription().equals(other.getDescription()))
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		return true;
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

}
