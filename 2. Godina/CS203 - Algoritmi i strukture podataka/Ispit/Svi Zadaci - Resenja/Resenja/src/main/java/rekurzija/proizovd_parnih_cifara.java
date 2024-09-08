package rekurzija;

public class proizovd_parnih_cifara {
    public static void main(String[] args) {

        System.out.println(productOfEvenDigits(23444132)); // 256
        System.out.println(productOfEvenDigits(2341)); // 8
        System.out.println(productOfEvenDigits(10492)); // 0

    }

    private static int productOfEvenDigits(int number) {
        int lastDigit = number % 10;

        if (number == 0) {
            return 1;
        } else if (lastDigit % 2 == 0) {
            return lastDigit * productOfEvenDigits(number / 10);
        } else {
            return productOfEvenDigits(number / 10);
        }

    }
}
