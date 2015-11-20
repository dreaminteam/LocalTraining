package by.training.java.grodno.az.data.model;

public class Coefficient implements IPersistent{

	private int id;
	private double value;
	private RateLine rateLine;
	private RacingLine racingLine;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public RateLine getRateLine() {
		return rateLine;
	}

	public void setRateLine(RateLine rateLine) {
		this.rateLine = rateLine;
	}

	public RacingLine getRacingLine() {
		return racingLine;
	}

	public void setRacingLine(RacingLine racingLine) {
		this.racingLine = racingLine;
	}
	
	
}
