package by.epam.andrewzenov.entities;

import by.epam.andrewzenov.annotations.Run;
import by.epam.andrewzenov.annotations.Vehicle;

@Vehicle(name = "submarine")
public class AtomicSubmarine {

	private String name;
	private String country;
	private Weapons mainWeapon;
	private boolean isStart;

	public AtomicSubmarine(){
	}
	
	public AtomicSubmarine(String name, String country, Weapons mainWeapon) {
		super();
		this.name = name;
		this.country = country;
		this.mainWeapon = mainWeapon;
		this.isStart = false;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	@Run
	private void startSubmarine() throws InterruptedException {
		Motor motor = new Motor();
		motor.startMotor();
	}

	class Motor {

		public void startMotor() throws InterruptedException {
			if (AtomicSubmarine.this.isStart) {
				System.out.println("Motor start working");
				return;
			}
			AtomicSubmarine.this.setStart(true);
			System.out.println("Motor not working. Restarting engine...");
			waitingToStart(5000);
			startMotor();
		}

		private void waitingToStart(int time) throws InterruptedException {
			System.out.print("Waiting to start engine .");
			for (int i = 0; i < 10; i++) {
				System.out.print(" .");
				Thread.sleep(time / 10);
			}
			System.out.println();
		}

	}

}
