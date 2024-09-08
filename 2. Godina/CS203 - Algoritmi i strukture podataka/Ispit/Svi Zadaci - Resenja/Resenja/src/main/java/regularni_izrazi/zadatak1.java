package regularni_izrazi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zadatak1 {
    public static boolean isValidSubjectCode(String subject)
    {
        String regex = "^(CS|SE|IT)[1-9]\\d{2}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(subject);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] subjects = new String[]{"CS101", "SE102", "IT103", "CS104", "SE105", "IT106", "CS107", "SE108"};

        for (String subject : subjects) {
            if (isValidSubjectCode(subject)) {
                System.out.println(subject + " is valid subject code.");
            } else {
                System.out.println(subject + " is not valid subject code.");
            }
        }
    }
}
