package regularni_izrazi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class vreme {
    public static void main(String[] args) {
        String text = "The meeting is at 09:45 and the deadline is 13:30:45. Remember to call at 23:59.";
        String regex = "\\b(?:[01]\\d|2[0-3]):[0-5]\\d(?::[0-5]\\d)?\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found time: " + matcher.group());
        }
    }
}
