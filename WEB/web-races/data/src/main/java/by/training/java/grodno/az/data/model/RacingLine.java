package by.training.java.grodno.az.data.model;

public class RacingLine extends AbstractEntity{
	
	private int id;
	private HourseRacing hourseRacing;
	private Participant participant;
	private int result;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HourseRacing gethRacing() {
		return hourseRacing;
	}

	public void sethRacing(HourseRacing hRacing) {
		this.hourseRacing = hRacing;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
