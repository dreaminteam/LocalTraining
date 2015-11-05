package by.epam.andrewzenov.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Film implements Serializable {

	final private String name;
	private transient String description;
	private List<Actor> authors;

	public Film() {
		super();
		this.name = "Without name";
		this.authors = new ArrayList<>();
	}

	public Film(String name) {
		super();
		this.name = name;
		this.authors = new ArrayList<>();
	}

	public List<Actor> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Actor> authors) {
		this.authors = authors;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Film [name=" + name + ", description=" + description + ", authors=" + authors + "]";
	}


}
