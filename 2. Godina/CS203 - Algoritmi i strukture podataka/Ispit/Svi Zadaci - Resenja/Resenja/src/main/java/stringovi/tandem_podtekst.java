package stringovi;

import java.util.ArrayList;
import java.util.List;

//naci u stringu tandem podtekst
// Tandem podtekst je tekst koji se nalazi dva puta jedan za drugim

public class tandem_podtekst {
    public static void main(String[] args) {
        String text = "xyzabcabcabcabcpq";
        System.out.println(findLongestTandemSubstring(text));
    }

    public static List<String> findLongestTandemSubstring(String text) {
        text = text.toLowerCase();

        List<String> tandemi = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            if (i + 2 > text.length()) continue;
            String pattern = text.substring(i, i + 2);

            for (int j = i + 2; j < text.length(); j++) {
                if (j + pattern.length() > text.length()) break;
                if (pattern.length() > text.length() / 2) break;
                String match = text.substring(j, j + pattern.length());

                if (pattern.equals(match)) {
                    if (!tandemi.contains(pattern)) {
                        tandemi.add(pattern);
                    }
                }

                pattern = pattern + text.substring(j, j + 1);
            }
        }

        return tandemi;
    }
}
