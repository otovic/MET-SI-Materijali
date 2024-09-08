package rekurzija;

public class zbir_cifara_paran {
    public static void main(String[] args) {

        System.out.println(isSumOfDigitsEven(2341)); // true
        System.out.println(isSumOfDigitsEven(123)); // true
        System.out.println(isSumOfDigitsEven(23)); // false
        System.out.println(isSumOfDigitsEven(5)); // false
        System.out.println(isSumOfDigitsEven(2)); // true
        System.out.println(isSumOfDigitsEven(78436)); // true

    }

    private static boolean isSumOfDigitsEven(int number) {
        if (number == 0) {
            return true;
        }

        int digit = number % 10;
        boolean a = digit % 2 == 0;
        boolean b = isSumOfDigitsEven(number / 10);

        return a && b || !a && !b;
    }
}
