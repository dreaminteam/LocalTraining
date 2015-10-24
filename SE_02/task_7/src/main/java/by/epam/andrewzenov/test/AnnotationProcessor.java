package by.epam.andrewzenov.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import by.epam.andrewzenov.annotations.Run;
import by.epam.andrewzenov.annotations.Vehicle;
import by.epam.andrewzenov.entities.AtomicSubmarine;
import by.epam.andrewzenov.entities.PrettyPrintingMap;

public class AnnotationProcessor {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		//Map<String, Object> map = getVehicles(AtomicSubmarine.class);
		//System.out.println(new PrettyPrintingMap<>(map));
		startRunMethods(AtomicSubmarine.class);
	}

	public static Map<String, Object> getVehicles(Class<?>... cl)
			throws InstantiationException, IllegalAccessException {
		Map<String, Object> map = new HashMap<>();
		for (Class<?> c : cl) {
			if (c.isAnnotationPresent(Vehicle.class)) {

				Vehicle ann = c.getAnnotation(Vehicle.class);
				Object o = c.newInstance();
				map.put(ann.name(), o);

			}
		}
		return map;
	}

	public static void startRunMethods(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			if (m.isAnnotationPresent(Run.class)) {
				try {
					m.setAccessible(true);
					m.invoke(clazz.newInstance());
				} catch (Exception e) {
					Run ann = m.getAnnotation(Run.class);
					if (ann.suppressException()) {
						System.err.println(e.getMessage());
					} else {
						throw new RuntimeException();
					}
				}
			}
		}
	}

	public static List<Method> runMethodsWithAnnatRun(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		List<Method> result = new ArrayList<>();
		for (Method m : methods) {
			if (m.isAnnotationPresent(Run.class)) {
				result.add(m);
			}
		}
		return result;
	}

}
