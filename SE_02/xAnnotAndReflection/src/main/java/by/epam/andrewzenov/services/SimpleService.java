package by.epam.andrewzenov.services;

import by.epam.andrewzenov.annotations.Init;
import by.epam.andrewzenov.annotations.Service;

@Service(name = "UltraSuperSimpleService")
public class SimpleService {
	@Init
	private void initService() {
		System.out.println("Run initService from SimpleService");
	}

	public void otherMethod() {
		System.out.println("OtherMethod");
	}

}
