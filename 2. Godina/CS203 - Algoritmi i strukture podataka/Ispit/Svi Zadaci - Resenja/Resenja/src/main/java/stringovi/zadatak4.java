package stringovi;

//dat je tekst T i rec S. potrebno je naci rec iz teksta T koja im anjduzi prefiks sa recju S

public class zadatak4 {
    // Funkcija koja pronalazi reč sa najdužim prefiksom
    public static String findLongestPrefixWord(String text, String word) {
        // Razdvajamo tekst na reči
        String[] words = text.split("\\s+");
        String longestPrefixWord = "";
        int maxPrefixLength = 0;

        // Prolazimo kroz sve reči u tekstu
        for (String w : words) {
            // Pronalazimo dužinu zajedničkog prefiksa
            int prefixLength = commonPrefixLength(w, word);

            // Ako je dužina prefiksa veća od trenutno najveće, ažuriramo rezultate
            if (prefixLength > maxPrefixLength) {
                maxPrefixLength = prefixLength;
                longestPrefixWord = w;
            }
        }

        return longestPrefixWord;
    }

    // Funkcija koja računa dužinu zajedničkog prefiksa između dve reči
    private static int commonPrefixLength(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        int length = 0;

        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                length++;
            } else {
                break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        // Primeri
        String text = "apple apply application ape appapricot";
        String word = "app";

        // Poziv funkcije i ispis rezultata
        String result = findLongestPrefixWord(text, word);
        System.out.println("Reč sa najdužim prefiksom: " + result);
    }
}
