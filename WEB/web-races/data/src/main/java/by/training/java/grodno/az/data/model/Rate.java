package by.training.java.grodno.az.data.model;

import by.training.java.grodno.az.data.entities.AbstractEntity;

public class Rate extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private int id;
	private double value;
	private double coefficientValue;

	private int playerId;
	private int rateTypeId;
	private int coefficientId;

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

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getRateTypeId() {
		return rateTypeId;
	}

	public void setRateTypeId(int rateTypeId) {
		this.rateTypeId = rateTypeId;
	}

	public int getCoefficientId() {
		return coefficientId;
	}

	public void setCoefficientId(int coefficientId) {
		this.coefficientId = coefficientId;
	}

	public double getCoefficientValue() {
		return coefficientValue;
	}

	public void setCoefficientValue(double coefficientValue) {
		this.coefficientValue = coefficientValue;
	}

	@Override
	public String toString() {
		return "Rate [id=" + id + ", value=" + value + ", coefficientValue=" + coefficientValue + ", playerId="
				+ playerId + ", rateTypeId=" + rateTypeId + ", coefficientId=" + coefficientId + "]";
	}


}
