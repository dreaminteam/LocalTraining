package by.training.java.grodno.az.data.entities;

import java.io.Serializable;

public class RacingLineView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int racingLineId;
	private String racingLine;
	private int countParticipant;

	public int getRacingLineId() {
		return racingLineId;
	}

	public void setRacingLineId(int racingLineId) {
		this.racingLineId = racingLineId;
	}

	public String getRacingLine() {
		return racingLine;
	}

	public void setRacingLine(String racingLine) {
		this.racingLine = racingLine;
	}

	public int getCountParticipant() {
		return countParticipant;
	}

	public void setCountParticipant(int countParticipant) {
		this.countParticipant = countParticipant;
	}

}
