package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select:\n1 -> Custom matrix\n2 -> Random matrix");
        System.out.print("Your option -> ");
        int option = scanner.nextInt();
        System.out.println();
        if (option == 1) {
            int dimension = 0;
            System.out.print("Enter the dimension of the matrix -> ");
            try {
                dimension = scanner.nextInt();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid dimension");
            }
            System.out.println();

            int[][] matrix = new int[dimension][dimension];

            for (int i = 0; i < dimension; i++) {
                System.out.print("Enter the row " + (i + 1) + " e.g. (1, 2, 3 ... )-> ");
                String[] row = scanner.next().split(",");
                if (row.length != dimension) throw new IllegalArgumentException("Invalid row length");

                for (int j = 0; j < dimension; j++) matrix[i][j] = Integer.parseInt(row[j]);
            }

            Utils.checkRowValues(matrix);
            Utils.printMatrix(matrix);

            CustomAlgorithm.max(matrix);
        } else if (option == 2) {
            int dimension = new Random().nextInt(10) + 5;
            int[][] matrix = new int[dimension][dimension];

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) matrix[i][j] = new Random().nextInt(2);
            }
            Utils.printMatrix(matrix);

            CustomAlgorithm.max(matrix);
        } else {
            throw new IllegalArgumentException("Invalid option");
        }
    }
}