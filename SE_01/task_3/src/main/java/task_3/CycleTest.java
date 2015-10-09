package task_3;

import java.util.LinkedHashMap;
import java.util.Map;

public class CycleTest {

	public static void main(String[] args) {

		// [a,b] - segment(b>a), h - step
		double a = -2;
		double b = 8;
		double h = 2;

		CycleTest cycleTest = new CycleTest();

		LinkedHashMap<Double, Double> myMap = (LinkedHashMap<Double, Double>) cycleTest.buildTable(a, b, h);
		printTable(myMap);

	}

	public Map<Double, Double> buildTable(double beginSegment, double endSegment, double stepOfSegment) {

		Map<Double, Double> resultMap = new LinkedHashMap<>();
		double nextElem = beginSegment;
		do {
			resultMap.put(nextElem, function(nextElem));
			nextElem += stepOfSegment;
		} while (nextElem < endSegment);
		resultMap.put(endSegment, function(endSegment));
		return resultMap;
	}

	private static double function(double argument) {

		return Math.tan(2 * argument) - 3;
	}

	public static void printTable(Map<Double, Double> staff) {

		for (Map.Entry entry : staff.entrySet()) {
			Double key = (Double) entry.getKey();
			Double value = (Double) entry.getValue();
			System.out.println(key + " | " + value);
		}
	}

}
