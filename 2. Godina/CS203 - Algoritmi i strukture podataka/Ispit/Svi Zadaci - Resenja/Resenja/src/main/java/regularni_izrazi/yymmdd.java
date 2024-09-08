package regularni_izrazi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class yymmdd {
    public static void main(String[] args) {

        System.out.println("Are these SQL datetime formats valid? ");

        System.out.println(isSQLDatetimeFormatValid("2022-01-31 23:59:59")); // true
        System.out.println(isSQLDatetimeFormatValid("2018-01-31 01:24:59")); // true
        System.out.println(isSQLDatetimeFormatValid("2021-12-31 00:00:14")); // true
        System.out.println(isSQLDatetimeFormatValid("2021-11-23 23:40:60")); // false

    }

    private static boolean isSQLDatetimeFormatValid(String str) {
        String regex = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]) (2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
