package stringovi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Dat je tekst S i broj k
// Pronalazenje palindroma duzine k u tekstu
public class zadatak7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter length: ");
        String s = "google";
        findAllPalindromes(s, input);

        input.close();
    }

    private static void findAllPalindromes(String str, Scanner input) {
        int k = input.nextInt();

        if (str == null) {
            return;
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            expand(str, i, i, set);
            expand(str, i, i + 1, set);
        }

        for (String s : set) {
            if (s.length() == k) {
                System.out.println(s);
            }
        }
    }

    private static void expand(String str, int low, int high, Set<String> set) {
        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            set.add(str.substring(low, high + 1));
            low--;
            high++;
        }
    }
}
