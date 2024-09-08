package stringovi;

import java.util.HashMap;
import java.util.Map;

//dat je tekst s i broj k. potrebno je naci najvecu rec s2 koja se u tekstu s nalazi k puta

public class zadatak3 {
    public static void main(String[] args) {
        String text = "apple banana apple orange banana apple apple banana";
        int k = 3;

        String result = findLongestWordWithExactCount(text, k);
        System.out.println("Najveća reč koja se pojavljuje tačno " + k + " puta je: " + result);
    }

    // Metoda koja pronalazi najveću reč koja se pojavljuje tačno k puta
    public static String findLongestWordWithExactCount(String text, int k) {
        // Podela teksta na reči
        String[] words = text.split("\\s+");

        // Mapiranje reči na broj njihovih pojavljivanja
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Pronalaženje najveće reči koja se pojavljuje tačno k puta
        String longestWord = "";
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if (count == k && word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }
}
