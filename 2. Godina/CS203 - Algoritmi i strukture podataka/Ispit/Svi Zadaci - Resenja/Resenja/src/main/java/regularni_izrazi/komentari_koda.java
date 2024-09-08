package regularni_izrazi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class komentari_koda {
    public static String removeComents(String code)
    {
        code = code.replaceAll("//.*", "");

        Pattern pattern = Pattern.compile("/\\*.*?\\/", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(code);
        return matcher.replaceAll("");
    }

    public static void main(String[] args) {
        String codeWithComments = "Your Java code" +
                "// this is a comment line" +
                "/* how are you doing" +
                "hello" +
                " */";

        System.out.println(removeComents(codeWithComments));
    }
}
