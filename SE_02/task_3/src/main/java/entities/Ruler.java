package entities;

public class Ruler extends Stationery {

	private int length;

	public Ruler(Double cost) {
		super(cost);
		setLength(20);
	}

	public Ruler(Double cost, int length) {
		super(cost);
		setLength(length);
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "[lenth:" + getLength() + "]";
	}

}
