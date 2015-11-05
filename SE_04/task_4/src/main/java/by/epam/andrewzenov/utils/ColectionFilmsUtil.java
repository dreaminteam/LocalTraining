package by.epam.andrewzenov.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import by.epam.andrewzenov.entities.ColectionOfFilms;
import by.epam.andrewzenov.entities.Film;

public class ColectionFilmsUtil {

	public static ColectionOfFilms createColectionOfFilms(String name) {
		return new ColectionOfFilms(name);
	}

	public static void addFilmToColection(ColectionOfFilms colectionOfFilms, Film film) {
		colectionOfFilms.getFilms().add(film);
	}

	public static void deleteFilmFromColectionByIndex(ColectionOfFilms colectionOfFilms, int indexFilm) {
		colectionOfFilms.getFilms().remove(indexFilm);
	}

	public static void saveToFile(ColectionOfFilms cFilms, final String saveFile) {
		try (FileOutputStream out = new FileOutputStream(new File(saveFile));
				ObjectOutputStream oos = new ObjectOutputStream(out);) {
			oos.writeObject(cFilms);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ColectionOfFilms importColection(final String saveFile) {
		ColectionOfFilms cFilms = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {
			cFilms = (ColectionOfFilms) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return cFilms;
	}

}
