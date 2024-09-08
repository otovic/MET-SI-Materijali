package rekurzija;

public class paran_broj_cifara {
    private static int sumOfDigits(int number) {
        // Baza rekurzije: kada je broj 0, zbir cifara je 0
        if (number == 0) {
            return 0;
        }
        // Rekurzivni slučaj: zbir poslednje cifre + zbir cifara ostatka broja
        return (number % 10) + sumOfDigits(number / 10);
    }

    // Funkcija koja proverava da li je zbir cifara paran
    public static boolean isSumOfDigitsEven(int number) {
        int sum = sumOfDigits(number);
        // Proverava da li je zbir cifara paran
        return (sum % 2 == 0);
    }

    public static void main(String[] args) {
        int number = 123456; // Primer broja za proveru

        // Proverava i ispisuje rezultat
        boolean result = isSumOfDigitsEven(number);
        System.out.println("Da li je zbir cifara broja " + number + " paran? " + result);
    }
}
