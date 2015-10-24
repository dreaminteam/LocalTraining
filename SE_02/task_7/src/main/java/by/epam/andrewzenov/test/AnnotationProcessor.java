package by.epam.andrewzenov.test;

import by.epam.andrewzenov.annotations.Service;
import by.epam.andrewzenov.services.LazyService;
import by.epam.andrewzenov.services.SimpleService;

public class AnnotationProcessor {

	public static void main(String[] args) {
		inspectedService(SimpleService.class);
		inspectedService(LazyService.class);
		inspectedService(String.class);
	}

	static void inspectedService(Class<?> service) {
		if (service.isAnnotationPresent(Service.class)) {
			Service ann = service.getAnnotation(Service.class);
			System.out.println(ann);
			System.out.println(ann.name());
			System.out.println(ann.lazyLoad());
		}
	}

}
