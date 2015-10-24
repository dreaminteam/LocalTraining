package by.epam.andrewzenov.services;

import by.epam.andrewzenov.annotations.Init;
import by.epam.andrewzenov.annotations.Service;

@Service(name = "UltraSuperLazyService")
public class LazyService {
	@Init
	public void lazyInit() throws Exception {
		System.out.println("Run lazyService from LazyService");
	}

}
