package by.training.java.grodno.az.data.model;

import by.training.java.grodno.az.data.entities.AbstractEntity;

public class RacingLine extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int hourseRacingId;
	private int participantId;
	private int result;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHourseRacingId() {
		return hourseRacingId;
	}

	public void setHourseRacingId(int hourseRacingId) {
		this.hourseRacingId = hourseRacingId;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "RacingLine [id=" + id + ", hourseRacingId=" + hourseRacingId + ", participantId=" + participantId
				+ ", result=" + result + "]";
	}

}
