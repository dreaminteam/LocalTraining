package task_5;

import java.util.Arrays;

public class MatrixTest {

	public static void main(String[] args) {

		MatrixTest matrixTest = new MatrixTest();

		int sizeOfMatrix = 10;

		int[][] myMatrix = matrixTest.init(sizeOfMatrix);

		matrixTest.printMatrix(myMatrix);

	}

	public int[][] init(int size) {
		int[][] result = new int[size][size];
		int temp = size - 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j || i + j == temp) {
					result[i][j] = 1;
				} else {
					result[i][j] = 0;
				}
			}
		}
		return result;
	}

	public void printMatrix(int[][] matrix) {
		for (int[] string : matrix) {
			System.out.println(Arrays.toString(string));
		}
	}

}
