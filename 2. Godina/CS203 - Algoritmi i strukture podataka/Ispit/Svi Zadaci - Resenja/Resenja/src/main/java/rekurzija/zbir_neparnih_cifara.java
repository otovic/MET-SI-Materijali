package rekurzija;

public class zbir_neparnih_cifara {
    public static void main(String[] args) {

        System.out.println(sumOfOddDigits(12341)); // 5
        System.out.println(sumOfOddDigits(538185)); // 14
        System.out.println(sumOfOddDigits(57421)); // 13

    }

    private static int sumOfOddDigits(int number) {
        int lastDigit = number % 10;

        if (number == 0) {
            return 0;
        } else if (lastDigit % 2 != 0) {
            return lastDigit + sumOfOddDigits(number / 10);
        } else {
            return sumOfOddDigits(number / 10);
        }

    }
}
