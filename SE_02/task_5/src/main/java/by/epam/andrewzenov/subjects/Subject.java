package by.epam.andrewzenov.subjects;

public abstract class Subject<T extends Number> {

	Class<T> clazz;

	public Subject(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Class<T> getClazz() {
		return clazz;
	}
}
