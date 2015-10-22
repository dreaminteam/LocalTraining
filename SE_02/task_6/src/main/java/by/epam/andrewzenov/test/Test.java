package by.epam.andrewzenov.test;

import by.epam.andrewzenov.entities.AtomicSubmarine;
import by.epam.andrewzenov.entities.Weapons;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		AtomicSubmarine submarine = new AtomicSubmarine("Epam", "Belarus", Weapons.BALLISTIC_MISSILE);
		submarine.startSubmarine();
	}
}