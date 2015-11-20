package by.epam.andrewzenov.data.model;

public class Participant {

	private int id;
	private Hourse hourse;
	private Jockey jockey;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hourse getHourse() {
		return hourse;
	}

	public void setHourse(Hourse hourse) {
		this.hourse = hourse;
	}

	public Jockey getJockey() {
		return jockey;
	}

	public void setJockey(Jockey jockey) {
		this.jockey = jockey;
	}
	
}
