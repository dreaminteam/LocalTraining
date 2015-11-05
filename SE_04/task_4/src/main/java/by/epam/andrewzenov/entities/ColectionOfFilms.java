package by.epam.andrewzenov.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ColectionOfFilms implements Serializable {

	final private String name;
	private List<Film> films;

	public ColectionOfFilms(String name) {
		super();
		this.name = name;
		this.films = new ArrayList<>();
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ColectionOfFilms [name=" + name + ", films=" + films + "]";
	}

}
