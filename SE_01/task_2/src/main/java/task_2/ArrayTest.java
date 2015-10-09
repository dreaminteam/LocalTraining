package task_2;

//import java.util.ArrayList;
//import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {

		int arrayLenght = 10; // n>0

		ArrayTest arrayTest = new ArrayTest();

		int[] myArray = arrayTest.init(arrayLenght);

		print(myArray);
		multiply(myArray);
		print(myArray);

	}

	public int[] init(int lenghtOfArray) {
		int[] result = new int[lenghtOfArray];
		for (int i = 0; i < lenghtOfArray; i++) {
			result[i] = 2 * (int) (Math.random() * 10);
		}
		return result;
	}

	public static void multiply(int[] array) {
		int i = 1;
		while (i < array.length) {
			array[i] *= array[i - 1];
			i += 2;
		}
	}

	public static void print(int[] array) {
		int i = 0;
		System.out.print("[ ");
		do {
			System.out.print(array[i++] + "  ");
		} while (i < array.length);
		System.out.println("]");
	}
}
