package org.example;

public class CustomAlgorithm {
    public static void max(int [][] matrix) {
        long startTime = System.nanoTime();

        calculate(matrix);

        long endTime = System.nanoTime();
        System.out.println("Custom algorithm execution time: " + ((endTime - startTime) / 1000000) + "ms");
    }

    private static int getRowLength(int[] row, int start) {
        int length = 0;
        for (int i = start; i < row.length; i++) {
            if (row[i] == 1) length++;
            else break;
        }
        return length;
    }

    private static void calculate(int [][] matrix) {
        int [] max = new int[2];
        int boxStart = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = boxStart; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    int length = getRowLength(matrix[i], j);
                    if (length == 1) continue;

                    int height = 1;
                    for (int k = i + 1; k < matrix.length; k++) {
                        if (matrix[k][j] == 1) {
                            int subLength = getRowLength(matrix[k], j);
                            if (subLength > length && subLength > 1) subLength = length;
                            else if (subLength < length) length = subLength;
                            height++;
                        } else {
                            break;
                        }
                    }

                    if (length > 1 && height > 1 && length * height > max[0] * max[1]) {
                        max[0] = length;
                        max[1] = height;
                    }
                }
            }
        }

        System.out.println("Max box: " + max[0] + "x" + max[1]);
    }
}
