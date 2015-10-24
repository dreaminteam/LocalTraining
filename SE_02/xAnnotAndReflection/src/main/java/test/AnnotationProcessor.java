package by.epam.andrewzenov.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam.andrewzenov.annotations.Init;
import by.epam.andrewzenov.annotations.Service;
import by.epam.andrewzenov.entities.PrettyPrintingMap;
import by.epam.andrewzenov.services.LazyService;
import by.epam.andrewzenov.services.SimpleService;

public class AnnotationProcessor {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		/*
		 * inspectedService(SimpleService.class);
		 * inspectedService(LazyService.class); inspectedService(String.class);
		 */
		/*
		 * getMethodsWithAnnatInit(SimpleService.class);
		 * getMethodsWithAnnatInit(LazyService.class);
		 * getMethodsWithAnnatInit(String.class);
		 */

		Map<String, Object> map = getServices(SimpleService.class, LazyService.class);
		// System.out.println(new PrettyPrintingMap<>(map));
		runInitMethods(SimpleService.class);
	}

	public static Map<String, Object> getServices(Class<?>... cl)
			throws InstantiationException, IllegalAccessException {
		Map<String, Object> map = new HashMap<>();
		for (Class<?> c : cl) {
			if (c.isAnnotationPresent(Service.class)) {

				Service ann = c.getAnnotation(Service.class);
				Object o = c.newInstance();
				map.put(ann.name(), o);

			}
		}
		return map;
	}

	public static void runInitMethods(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			if (m.isAnnotationPresent(Init.class)) {
				try {
					m.setAccessible(true);
					m.invoke(clazz.newInstance());
				} catch (Exception e) {
					Init ann = m.getAnnotation(Init.class);
					if (ann.suppressException()) {
						System.err.println(e.getMessage());
					} else {
						throw new RuntimeException();

					}
				}
			}
		}
	}

	public static List<Method> runMethodsWithAnnatInit(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		List<Method> result = new ArrayList<>();
		for (Method m : methods) {
			if (m.isAnnotationPresent(Init.class)) {
				result.add(m);
			}
		}
		return result;
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
