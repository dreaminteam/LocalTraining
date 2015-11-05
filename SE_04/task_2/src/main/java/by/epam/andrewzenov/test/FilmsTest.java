package by.epam.andrewzenov.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import by.epam.andrewzenov.entities.Actor;
import by.epam.andrewzenov.entities.ColectionOfFilms;
import by.epam.andrewzenov.entities.Film;
import by.epam.andrewzenov.utils.ColectionFilmsUtil;

public class FilmsTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Actor a1 = new Actor("name_1", "surname_1");
		Actor a2 = new Actor("name_2", "surname_2");
		Actor a3 = new Actor("name_3", "surname_3");

		List<Actor> actors1 = new ArrayList<>();
		actors1.add(a1);
		actors1.add(a2);

		List<Actor> actors2 = new ArrayList<>();
		actors2.add(a1);
		actors2.add(a3);

		Film f1 = new Film("Afonia");
		f1.setAuthors(actors1);

		Film f2 = new Film("Zhmurki");
		f2.setAuthors(actors2);
		f2.setDescription("nice");

		List<Film> films = new ArrayList<>();
		films.add(f1);
		films.add(f2);

		ColectionOfFilms cFilms = ColectionFilmsUtil.createColectionOfFilms("Horrors");
		cFilms.setFilms(films);

		System.out.println(cFilms);

		// serializing
		final String saveFile = "save.films";
		ColectionFilmsUtil.saveToFile(cFilms, saveFile);

		// deserializing
		ColectionOfFilms cFilms2 = ColectionFilmsUtil.importColection(saveFile);
		System.out.println(cFilms2);
		Film f3 = new Film();

		ColectionFilmsUtil.addFilmToColection(cFilms2, f3);

		ColectionFilmsUtil.saveToFile(cFilms2, saveFile);
		ColectionOfFilms cFilms3 = ColectionFilmsUtil.importColection(saveFile);
		System.out.println(cFilms3);
	}
}
