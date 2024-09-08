import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Brojevi {


    public static void main(String[] args) {

        int[] minDiffArr = {2, 4, 2, 7};
        minimalDifference(minDiffArr);


        System.out.println(splitIntoPrimes(223));

        int[][] matrix = {
                {7, 4, 1, 8},
                {6, 5, 2, 9},
                {3, 10, 11, 12},
                {16, 15, 14, 13}
        };

        int key = 5;


        alternatingMatrixSort(matrix);

        System.out.println("Sorted Matrix:");
        printMatrix(matrix);

        boolean keyFound = binarySearchOfMatrix(matrix, key);

        System.out.println("Key " + key + " is " + (keyFound ? "found" : "not found") + " in the matrix.");

    }

    // podeli niz u dve grupe tako da je razlika zbirova elemenata u grupama minimalna
    public static void minimalDifference(int[] initArray)
    {
        Arrays.sort(initArray);
        int[] sortedArray = new int[initArray.length];
        for(int i = 0, j = initArray.length - 1; i < initArray.length; i++, j--)
        {
            sortedArray[i] = initArray[j];
        }

        List<Integer> firstArray = new ArrayList<>();
        List<Integer> secondArray = new ArrayList<>();

        for(int number : sortedArray)
        {
            if(listSum(firstArray) <= listSum(secondArray))
            {
                firstArray.add(number);
            }
            else
            {
                secondArray.add(number);
            }
        }

        System.out.println("First Array:\t" + firstArray);
        System.out.println("Second Array:\t" + secondArray);
        System.out.println("Difference:\t" + Math.abs(listSum(firstArray) - listSum(secondArray)));
    }

    //Dat je broj n. Odrediti da li se on može podeliti na dva dela (povlačenjem crte između dve cifre), tako da oba dobijena broja budu prosta. (Traženo rešenje mora biti najmanje složenosti)
    public static String splitIntoPrimes(int number)
    {
        String numberString = String.valueOf(number);

        for(int i = 1; i < numberString.length(); i++)
        {
            int firstPart = Integer.parseInt(numberString.substring(0, i));
            int secondPart = Integer.parseInt(numberString.substring(i));

            if(isPrime(firstPart) && isPrime(secondPart))
            {
                return numberString.substring(0, i) + " | " + numberString.substring(i);
            }
        }

        return "NO";
    }

    //Neka je data matrica N × N . Sortirati elemente, upotrebom Quick sort-a, u matrici tako da su u prvoj vrsti svi rastući, u drugoj svi opadajući, i tako naizmenično.  Napisati program koji ispituje da li se ključ K nalazi u matrici korišćenjem binarnog pretraživanja.
    public static void matrixSort(int[][] matrix) {
        int N = matrix.length;

        // Flatten the matrix into a 1D array for sorting
        int[] flattenedMatrix = new int[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flattenedMatrix[index++] = matrix[i][j];
            }
        }

        // Sort the flattened array using Quick Sort
        Arrays.sort(flattenedMatrix);

        // Populate the matrix with sorted values in an alternating pattern
        index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = flattenedMatrix[index++];
            }
        }
    }

    public static void alternatingMatrixSort(int[][] matrix)
    {
        int N = matrix.length;

        // Flatten the matrix into a 1D array for sorting
        int[] flattenedMatrix = new int[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flattenedMatrix[index++] = matrix[i][j];
            }
        }

        // Sort the flattened array using Quick Sort
        Arrays.sort(flattenedMatrix);

        // Populate the matrix with sorted values in an alternating pattern
        index = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = flattenedMatrix[index++];
                }
            } else {
                for (int j = N - 1; j >= 0; j--) {
                    matrix[i][j] = flattenedMatrix[index++];
                }
            }
        }
    }

    public static boolean binarySearchOfMatrix(int[][] matrix, int key) {
        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            int low = 0;
            int high = N - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int midValue = matrix[i][mid];

                if (midValue == key) {
                    return true;
                } else if (midValue < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    //Util
    public static int listSum(List<Integer> array)
    {
        int total = 0;

        for(int number : array)
        {
            total += number;
        }

        return total;
    }

    public static boolean isPrime(int number)
    {
        if (number < 2)
            return false;

        for(int i = 2; i < Math.sqrt(number); i++)
        {
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static void printMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
