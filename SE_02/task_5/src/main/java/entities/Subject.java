package entities;

public enum Subject {
	ALGEBRA(true), GEOMETRY(true), FUNCTIONAL_ANALISIS(true), MECHANICS(true), PROGRAMMING(false), HISTORY(
			false), PHILOSOPHY(false);

	private boolean isInt;

	/**
	 * @return the isInt
	 */
	public boolean isInt() {
		return isInt;
	}

	private Subject(boolean isInt) {
		this.isInt = isInt;
	}

}
