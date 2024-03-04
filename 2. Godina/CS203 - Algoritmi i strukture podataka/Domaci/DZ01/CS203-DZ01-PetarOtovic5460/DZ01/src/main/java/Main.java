import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ZADATAK 1
        System.out.println(findLargestPrime(13195));
    }

    public static int findLargestPrime(int number) {
        if (number <= 1) {
            return -1;
        }
        for (int i = number; i > 1; i--) {
            if (number % i == 0 && isPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
