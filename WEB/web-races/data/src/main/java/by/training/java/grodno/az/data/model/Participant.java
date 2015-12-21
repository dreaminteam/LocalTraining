package by.training.java.grodno.az.data.model;

public class Participant extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int hourseId;
	private int jockeyId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHourseId() {
		return hourseId;
	}

	public void setHourseId(int hourseId) {
		this.hourseId = hourseId;
	}

	public int getJockeyId() {
		return jockeyId;
	}

	public void setJockeyId(int jockeyId) {
		this.jockeyId = jockeyId;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", hourseId=" + hourseId + ", jockeyId=" + jockeyId + "]";
	}

}
