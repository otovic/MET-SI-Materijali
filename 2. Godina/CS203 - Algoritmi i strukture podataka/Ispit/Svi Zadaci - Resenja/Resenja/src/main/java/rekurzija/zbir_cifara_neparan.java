package rekurzija;

public class zbir_cifara_neparan {
    public static void main(String[] args) {

        System.out.println(isSumOfDigitsOdd(2341, 0)); // false
        System.out.println(isSumOfDigitsOdd(123, 0)); // false
        System.out.println(isSumOfDigitsOdd(23, 0)); // true
        System.out.println(isSumOfDigitsOdd(5, 0)); // true
        System.out.println(isSumOfDigitsOdd(2, 0)); // false
        System.out.println(isSumOfDigitsOdd(78436, 0)); // false

    }

    private static boolean isSumOfDigitsOdd(int number, int sum) {
        int i = sum + number;

        if (number <= 0) {
            if (i % 2 != 0) {
                return true;
            } else {
                return false;
            }
        }

        return isSumOfDigitsOdd(number / 10, i);
    }
}
