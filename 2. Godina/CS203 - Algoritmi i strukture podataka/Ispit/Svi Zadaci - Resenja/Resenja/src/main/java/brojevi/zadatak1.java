package brojevi;
//// Odrediti da li se dati broj n moze podeliti na dva dela (povlacenjem crte izmedju dve cifre), tako da oba dobijena broja budu prosta
public class zadatak1 {
    public static void main(String[] args) {

        findPair(2, 23); // 2|23
        findPair(3, 24); // Not possible to split!
        findPair(2, 53); // 2|53
        findPair(2, 5); // 2|5
        findPair(2, 41); // 2|41

    }

    private static int countDigits(int number) {
        if (number == 0) {
            return 0;
        }
        return 1 + countDigits(number / 10);
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int removeLastDigits(int n, int count) {
        return (int) (n / Math.pow(10, count));
    }

    private static int getLastDigits(int n, int count) {
        return (int) (n % Math.pow(10, count));
    }

    private static void findPair(int n, int m) {
        int a = n;
        int b = m;
        int counter = 1;
        int digits = countDigits(n);
        int arePrimes = 0;

        while (digits >= 1) {
            if (isPrimeNumber(a) && isPrimeNumber(b)) {
                System.out.println(a + "|" + b);
                arePrimes = 1;
                break;
            } else {
                a = removeLastDigits(n, counter);
                b = getLastDigits(n, counter);
                counter++;
                digits--;
            }
        }

        if (arePrimes == 0) {
            System.out.println("Not possible to split!");
        }
    }
}
