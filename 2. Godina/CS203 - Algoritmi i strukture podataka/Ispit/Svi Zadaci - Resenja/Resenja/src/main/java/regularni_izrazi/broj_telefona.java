package regularni_izrazi;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Regularni izraz (Regex) odgovara brojevima telefona u sledecem formatu: +381/64-5639-222
// Izdvajanje pozivnog broja drzave i njegovo ispisivanje kao poseban podatak
public class broj_telefona {
    public static void main(String[] args) {

        System.out.println(isValidNumber("+381/64-5639-222")); // true
        System.out.println(isValidNumber("+381/21-5639-342")); // false

    }

    private static boolean isValidNumber(String num) {
        String regex = "(\\+381)\\/([0-9]){2}-([0-9]){4}-([0-9]){3}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(num);

        List<String> list = new ArrayList<>();

        while (matcher.find()) {
            list.add(matcher.group(1));
        }

        System.out.println("Pozivni broj drzave je: " + list);
        return matcher.matches();
    }
}
