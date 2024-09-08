package stringovi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Napisati program koji pronalazi sve podstringove unutar zadatog stringa koji su anagrami unete
//        reči.
//        String: "babcabbacaabcbabcacaa", Reč: "aabbcc"
//        Izlaz: ["babcab", "abbaca", "bacabc"]

public class zadatak2 {
    private static boolean daLiSuAnagrami(String s1, String s2) {
        // Prvo sortiramo oba stringa i onda ih poredimo
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    // Metoda koja pronalazi sve anagramske podstringove
    public static List<String> pronadjiAnagramPodstringove(String text, String rec) {
        List<String> rezultat = new ArrayList<>();
        int duzinaReci = rec.length();

        // Prolazak kroz sve moguće podstringove dužine reci
        for (int i = 0; i <= text.length() - duzinaReci; i++) {
            String podstring = text.substring(i, i + duzinaReci);

            if (daLiSuAnagrami(podstring, rec)) {
                rezultat.add(podstring);
            }
        }
        return rezultat;
    }

    public static void main(String[] args) {
        String text = "babcabbacaabcbabcacaa";
        String rec = "aabbcc";

        List<String> anagramPodstringovi = pronadjiAnagramPodstringove(text, rec);
        System.out.println("Pronađeni anagramski podstringovi: " + anagramPodstringovi);
    }
}
