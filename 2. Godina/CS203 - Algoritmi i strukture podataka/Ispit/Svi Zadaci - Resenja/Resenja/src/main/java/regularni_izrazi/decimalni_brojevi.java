package regularni_izrazi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class decimalni_brojevi {
    public static void main(String[] args) {
        String text = "Here are some numbers: 123, -456.78, 0.99, -1234, and 567.89";

        // Regularni izraz za prepoznavanje decimalnih brojeva
        String regex = "-?\\b\\d+([.,]\\d+)?\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Ispis svih pronađenih decimalnih brojeva
        while (matcher.find()) {
            System.out.println("Found number: " + matcher.group());
        }
    }
}
