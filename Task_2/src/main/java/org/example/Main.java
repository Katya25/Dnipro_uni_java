package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

	private static final int MAX_SIZE = 20;
	private static final int RAND_MIN = 1;
	private static final int RAND_MAX = 50;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rows = readSize(sc, "Enter matrix height (1..20): ");
		int cols = readSize(sc, "Enter matrix width (1..20): ");

		int choice = readChoice(sc);

		int[][] matrix = (choice == 1)
				? createMatrixManualPositive(sc, rows, cols)
				: createMatrixRandom(rows, cols);

		System.out.println();
		System.out.println("Matrix:");
		printMatrix(matrix);

		int min = findMin(matrix);
		int max = findMax(matrix);
		double avg = calcArithmeticMean(matrix);
		double geo = calcGeometricMean(matrix);

		System.out.println();
		System.out.println("Results:");
		System.out.println("Min = " + min);
		System.out.println("Max = " + max);
		System.out.printf("Arithmetic mean = %.4f%n", avg);
		System.out.printf("Geometric mean = %.4f%n", geo);

		sc.close();
	}

	private static int readSize(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			if (!sc.hasNextInt()) {
				sc.next();
				System.out.println("Please enter an integer.");
				continue;
			}
			int value = sc.nextInt();
			if (value < 1 || value > MAX_SIZE) {
				System.out.println("Size must be between 1 and " + MAX_SIZE + ".");
				continue;
			}
			return value;
		}
	}

	private static int readChoice(Scanner sc) {
		while (true) {
			System.out.print("Choose input type: 1 - manual, 2 - random: ");
			if (!sc.hasNextInt()) {
				sc.next();
				System.out.println("Please enter 1 or 2.");
				continue;
			}
			int choice = sc.nextInt();
			if (choice == 1 || choice == 2) return choice;
			System.out.println("Please enter 1 or 2.");
		}
	}

	private static int[][] createMatrixManualPositive(Scanner sc, int rows, int cols) {
		int[][] m = new int[rows][cols];
		System.out.println("Enter " + (rows * cols) + " positive integers (> 0):");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				m[i][j] = readPositiveInt(sc, "a[" + i + "][" + j + "] = ");
			}
		}
		return m;
	}

	private static int readPositiveInt(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			if (!sc.hasNextInt()) {
				sc.next();
				System.out.println("Please enter an integer.");
				continue;
			}
			int value = sc.nextInt();
			if (value <= 0) {
				System.out.println("Value must be > 0.");
				continue;
			}
			return value;
		}
	}

	private static int[][] createMatrixRandom(int rows, int cols) {
		int[][] m = new int[rows][cols];
		Random rnd = new Random();
		int bound = RAND_MAX - RAND_MIN + 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				m[i][j] = RAND_MIN + rnd.nextInt(bound);
			}
		}
		return m;
	}

	private static void printMatrix(int[][] m) {
		for (int[] row : m) {
			for (int val : row) {
				System.out.printf("%6d", val);
			}
			System.out.println();
		}
	}

	private static int findMin(int[][] m) {
		int min = m[0][0];
		for (int[] row : m) {
			for (int val : row) {
				if (val < min) min = val;
			}
		}
		return min;
	}

	private static int findMax(int[][] m) {
		int max = m[0][0];
		for (int[] row : m) {
			for (int val : row) {
				if (val > max) max = val;
			}
		}
		return max;
	}

	private static double calcArithmeticMean(int[][] m) {
		long sum = 0;
		int count = 0;
		for (int[] row : m) {
			for (int val : row) {
				sum += val;
				count++;
			}
		}
		return (double) sum / count;
	}

	private static double calcGeometricMean(int[][] m) {
		int count = 0;
		double logSum = 0.0;
		for (int[] row : m) {
			for (int val : row) {
				logSum += Math.log(val);
				count++;
			}
		}
		return Math.exp(logSum / count);
	}
}