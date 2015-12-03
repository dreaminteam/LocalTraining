package by.training.java.grodno.az.data.model;

public class Hourse extends AbstractEntity {

	public Hourse() {
	}

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hourse [id=" + id + ", name=" + name + "]";
	}

}
