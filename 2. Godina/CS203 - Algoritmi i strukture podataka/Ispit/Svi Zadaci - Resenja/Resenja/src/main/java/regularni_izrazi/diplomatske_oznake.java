package regularni_izrazi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class diplomatske_oznake {
    public static void main(String[] args) {

        System.out.println(isValid("10-A-120")); // true
        System.out.println(isValid("144-M-005")); // true
        System.out.println(isValid("123-CMD-45")); // false
        System.out.println(isValid("01-CD-120")); // true
        System.out.println(isValid("1-M-003")); // false

    }

    private static boolean isValid(String str) {
        String regex = "([0-9]){2,3}-(A|M|P|CMD|CD)-([0-9]){3}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
