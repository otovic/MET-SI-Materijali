package rekurzija;

public class matrica_simetricna {
    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 3, 5},
                {3, 2, 4},
                {5, 4, 1}};

        System.out.println("Is matrix symmetric? " + isSymmetric(matrix1, 1, 0)); // true

        int[][] matrix2 = {
                {3, 5, 8},
                {3, 4, 7},
                {8, 5, 3}};

        System.out.println("Is matrix symmetric? " + isSymmetric(matrix2, 1, 0)); // false

    }

    private static boolean isSymmetric(int[][] matrix, int i, int j) {
        if (i < matrix.length && j < i) {
            if (matrix[i][j] == matrix[j][i]) {
                if (j == i - 1) {
                    return isSymmetric(matrix, i + 1, 0);
                } else {
                    return isSymmetric(matrix, i, j + 1);
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
