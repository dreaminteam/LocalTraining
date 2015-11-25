package by.training.java.grodno.az.data.model;

public class Rate extends AbstractEntity{

	private int id;
	private double value;
	private Player player;
	private RateType rateType;
	private Coefficient coefficient;

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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public RateType getRateType() {
		return rateType;
	}

	public void setRateType(RateType rateType) {
		this.rateType = rateType;
	}

	public Coefficient getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Coefficient coefficient) {
		this.coefficient = coefficient;
	}
	
}
