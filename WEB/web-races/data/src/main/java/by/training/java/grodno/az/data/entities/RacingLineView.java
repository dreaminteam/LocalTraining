package by.training.java.grodno.az.data.entities;

import java.io.Serializable;

import by.training.java.grodno.az.data.model.HourseRacing;

public class RacingLineView implements Serializable {

	private static final long serialVersionUID = 1L;

	private int racingLineId;
	private HourseRacing hourseRacing;
	private ParticipantView participantView;
	private int rusult;

	public int getRacingLineId() {
		return racingLineId;
	}

	public void setRacingLineId(int racingLineId) {
		this.racingLineId = racingLineId;
	}

	public HourseRacing getHourseRacing() {
		return hourseRacing;
	}

	public void setHourseRacing(HourseRacing hourseRacing) {
		this.hourseRacing = hourseRacing;
	}

	public ParticipantView getParticipantView() {
		return participantView;
	}

	public void setParticipantView(ParticipantView participantView) {
		this.participantView = participantView;
	}

	public int getRusult() {
		return rusult;
	}

	public void setRusult(int rusult) {
		this.rusult = rusult;
	}

}
