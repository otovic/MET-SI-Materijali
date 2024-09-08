package regularni_izrazi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class instagram {
    //korisničko ime društvene mreže Instagram. Imena mogu da uključuju samo cifre, mala i velika slova, donju crtu i tačku.
    //Ime ne sme da počinje niti da se završava tačkom. Zabranjeno je i da imamo dve uzastopne tačke
    public static boolean isValidInstagramUser(String username)
    {
        String regex = "^[a-zA-Z0-9_](?!.*[.]{2})[a-zA-Z0-9_.]*[a-zA-Z0-9_]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);

        return matcher.matches();

    }

    public static void main(String[] args) {
        System.out.println(isValidInstagramUser("username")); // true
        System.out.println(isValidInstagramUser("username.")); // false
        System.out.println(isValidInstagramUser("user..name")); // false
        System.out.println(isValidInstagramUser("user_name")); // true
        System.out.println(isValidInstagramUser("user_name.")); // false
        System.out.println(isValidInstagramUser("user_name..")); // false
        System.out.println(isValidInstagramUser("user_name_")); // true
        System.out.println(isValidInstagramUser("user_name_.")); // false
        System.out.println(isValidInstagramUser("user_name__")); // true
        System.out.println(isValidInstagramUser("user_name__.")); // false
        System.out.println(isValidInstagramUser("user_name__..")); // false
        System.out.println(isValidInstagramUser("user_name__a")); // true
        System.out.println(isValidInstagramUser("user_name__a.")); // false
        System.out.println(isValidInstagramUser("user_name__a..")); // false
        System.out.println(isValidInstagramUser("user_name__a_")); // true
        System.out.println(isValidInstagramUser("user_name__a_.")); // false
        System.out.println(isValidInstagramUser("user_name__a__")); // true
        System.out.println(isValidInstagramUser("user_name__a__.")); // false
        System.out.println(isValidInstagramUser("user_name__a__.")); // false
        System.out.println(isValidInstagramUser("user_name__a__a")); // true
        System.out.println(isValidInstagramUser("user_name__a__a.")); // false
        System.out.println(isValidInstagramUser("user_name__a__a..")); // false
        System.out.println(isValidInstagramUser("user_name__a__a_")); // true
        System.out.println(isValidInstagramUser("user_name__a__a_.")); // false
        System.out.println(isValidInstagramUser("user_name__a__a__")); // true
        System.out.println(isValidInstagramUser("user_name__a__a__.")); // false
        System.out.println(isValidInstagramUser("user_name__a__a__.")); // false
        System.out.println(isValidInstagramUser("user_name__a__a__a"));
    }
}
