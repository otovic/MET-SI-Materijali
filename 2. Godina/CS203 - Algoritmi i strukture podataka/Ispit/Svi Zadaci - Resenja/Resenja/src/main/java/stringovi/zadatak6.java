package stringovi;

import java.util.Scanner;

// Provera da li su dve unete reci anagrami
// Trazeno resenje treba da ima slozenost manju od O(n^2)

public class zadatak6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = input.nextLine().toLowerCase();
        System.out.print("Enter second string: ");
        String str2 = input.nextLine().toLowerCase();
        System.out.println(str1 + " and " + str2 + (isAnagram(str1, str2) ? " are anagrams." : " aren't anagrams."));

        input.close();
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] alphabet = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            alphabet[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            alphabet[s2.charAt(i) - 'a']--;
        }

        for (int a : alphabet) {
            if (a != 0) {
                return false;
            }
        }

        return true;
    }
}
