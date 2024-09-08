package rekurzija;

public class palindrom {
    public static void main(String[] args) {
        // Testiranje nekih primera
        String testString1 = "racecar";
        String testString2 = "hello";

        System.out.println(testString1 + " is palindrome: " + isPalindrome(testString1));
        System.out.println(testString2 + " is palindrome: " + isPalindrome(testString2));
    }

    // Rekurzivna funkcija za proveru da li je string palindrom
    public static boolean isPalindrome(String str) {
        // Poziv rekurzivne funkcije
        return isPalindromeHelper(str, 0, str.length() - 1);
    }

    // Pomoćna rekurzivna funkcija
    private static boolean isPalindromeHelper(String str, int left, int right) {
        // Ako su pokazivači jednaki ili prešli, string je palindrom
        if (left >= right) {
            return true;
        }

        // Ako se karakteri na pozicijama left i right ne poklapaju
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Rekurzivno proveri unutrašnji deo stringa
        return isPalindromeHelper(str, left + 1, right - 1);
    }
}
