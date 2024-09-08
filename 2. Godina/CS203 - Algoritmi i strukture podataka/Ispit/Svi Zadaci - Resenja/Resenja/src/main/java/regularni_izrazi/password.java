package regularni_izrazi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class password {
    public static void main(String[] args) {

        System.out.println("Are these passwords valid? ");

        System.out.println(isPasswordValid("A73fj67_")); // true
        System.out.println(isPasswordValid("a73fj67_")); // false
        System.out.println(isPasswordValid("F_fj293")); // false
        System.out.println(isPasswordValid("F_fj293s")); // true
        System.out.println(isPasswordValid("R589fgn_hd83")); // true

    }

    private static boolean isPasswordValid(String str) {
        String regex = "([A-Z]){1}([a-zA-Z0-9_]){7,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
