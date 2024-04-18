package org.example;

public class Utils {
    public static void checkRowValues(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (ints[j] != 0 && ints[j] != 1) throw new IllegalArgumentException("Invalid row value");
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        System.out.println("Matrix:");
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) System.out.print(ints[j] + " ");
            System.out.println();
        }
    }
}
