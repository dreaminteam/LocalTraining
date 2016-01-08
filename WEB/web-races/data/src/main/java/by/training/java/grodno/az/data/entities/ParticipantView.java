package by.training.java.grodno.az.data.entities;

import java.io.Serializable;

public class ParticipantView implements Serializable {

	private static final long serialVersionUID = 1L;

	private int participantId;
	private String jockeyFirstName;
	private String jockeyLastName;

	public String getJockeyLastName() {
		return jockeyLastName;
	}

	public void setJockeyLastName(String jockeyLastName) {
		this.jockeyLastName = jockeyLastName;
	}

	private String hourseName;

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public String getJockeyFirstName() {
		return jockeyFirstName;
	}

	public void setJockeyFirstName(String jockeyFirstName) {
		this.jockeyFirstName = jockeyFirstName;
	}

	public String getHourseName() {
		return hourseName;
	}

	public void setHourseName(String hourseName) {
		this.hourseName = hourseName;
	}

	public String toStringShort() {
		return "[Id=" + participantId + ", Jockey=" + jockeyFirstName.charAt(0) +". "+ jockeyLastName + ", Hourse="
				+ hourseName + "]";
	}

	@Override
	public String toString() {
		return "ParticipantView [Participant Id=" + participantId + ", Jockey first name=" + jockeyFirstName
				+ ", Jockey last name=" + jockeyLastName + ", Hourse name=" + hourseName + "]";
	}

}
