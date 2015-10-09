package task_4;

import java.util.Arrays;

public class FindMaxTest {

	public static void main(String[] args) {

		int n = 10;

		FindMaxTest findMaxTest = new FindMaxTest();

		double[] myArray = findMaxTest.init(n);

		System.out.println(Arrays.toString(myArray));
		System.out.print(findMaxTest.findMaxElem(myArray));

	}

	public double findMaxElem(double[] array) {

		if (array.length == 0 || ((array.length) % 2) != 0) {
			throw new IllegalArgumentException("Array con't be empty and indexes should be even number");
		}

		double max = Double.MIN_VALUE;
		int n = array.length - 1;
		for (int i = 0; i < array.length / 2; i++) {
			double sum = array[i] + array[n - i];
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	public double[] init(int length) {
		double[] result = new double[length];
		for (int i = 0; i < length; i++) {
			result[i] = 2 * (Math.random() * 10);
		}
		return result;
	}

}
