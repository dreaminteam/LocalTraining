package entities;

public class Student {

	private String name;
	private String surName;
	private int numOfIdCard;


	public Student(String name, String surName, int numOfIdCard) {
		super();
		this.name = name;
		this.surName = surName;
		this.numOfIdCard = numOfIdCard;
	}

	/**
	 * @return the numOfIdCard
	 */
	public int getNumOfIdCard() {
		return numOfIdCard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOfIdCard;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (getNumOfIdCard() != other.getNumOfIdCard())
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (getSurName() == null) {
			if (other.getSurName() != null)
				return false;
		} else if (!getSurName().equals(other.getSurName()))
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
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @return the mark
	 */
	public Number getMark() {
		return mark;
	}

	/**
	 * @param mark
	 *            the mark to set
	 */
	public <T extends Number> void setMark(T mark) {
		this.mark = mark;
	}

}
