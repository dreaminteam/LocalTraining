package by.training.java.grodno.az.data.entities;

import java.io.Serializable;

public class ParticipantView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int participantId;
	private String jockeyFullName;
	private String hourseName;
	
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getJockeyFullName() {
		return jockeyFullName;
	}
	public void setJockeyFullName(String jockeyFullName) {
		this.jockeyFullName = jockeyFullName;
	}
	public String getHourseName() {
		return hourseName;
	}
	public void setHourseName(String hourseName) {
		this.hourseName = hourseName;
	}
	
}
