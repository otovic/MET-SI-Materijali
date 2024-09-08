package stringovi;

import java.util.*;

//dat je tekst s i broj k. potrebno je naci najmanju rec S2 koja se u tekstu S nalazi k puta

public class zadatak5 {
    public static void main(String[] args) {
        // Unesi tekst i broj k
        String text = "this is a test text with test cases and words";
        int k = 2;

        // Pronađi najmanju reč koja se pojavljuje tačno k puta
        String result = findSmallestWord(text, k);
        System.out.println("Najmanja reč koja se pojavljuje tačno " + k + " puta je: " + result);
    }

    public static String findSmallestWord(String text, int k) {
        // Razdvoji tekst u reči
        String[] words = text.split("\\s+");

        // Broji pojavljivanja svake reči
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Filtriraj reči koje se pojavljuju tačno k puta
        List<String> candidates = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == k) {
                candidates.add(entry.getKey());
            }
        }

        // Ako nema reči koje se pojavljuju tačno k puta
        if (candidates.isEmpty()) {
            return "Nema reči koje se pojavljuju tačno " + k + " puta.";
        }

        // Sortiraj reči po dužini (najmanja prva)
        candidates.sort(Comparator.comparingInt(String::length));

        // Vrati najmanju reč
        return candidates.get(0);
    }
}
