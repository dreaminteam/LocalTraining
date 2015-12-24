package by.training.java.grodno.az.data.model;

import by.training.java.grodno.az.data.entities.AbstractEntity;

public class Rate extends AbstractEntity {

	private int id;
	private double value;
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

	@Override
	public String toString() {
		return "Rate [id=" + id + ", value=" + value + ", playerId=" + playerId + ", rateTypeId=" + rateTypeId
				+ ", coefficientId=" + coefficientId + "]";
	}

}
