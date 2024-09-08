import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static int nadji(String text, char c) {
        if (text.equals("")) return 0;

        if (text.toLowerCase().charAt(0) == c) return 1 + nadji(text.substring(1), c);
        else return 0 + nadji(text.substring(1), c);
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
