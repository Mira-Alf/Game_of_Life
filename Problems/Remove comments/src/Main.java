import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String codeWithComments = scanner.nextLine();

        String multilineComment = "/\\*.*?\\*/";
        String singlelineComment = "//.*";

        Pattern pattern = Pattern.compile(multilineComment);
        Matcher matcher = pattern.matcher(codeWithComments);
        while(matcher.find() == true) {
            codeWithComments = matcher.replaceAll("");
            matcher = pattern.matcher(codeWithComments);
        }


        pattern = Pattern.compile(singlelineComment);
        matcher = pattern.matcher(codeWithComments);
        while(matcher.find()) {
            codeWithComments = matcher.replaceAll("");
            matcher = pattern.matcher(codeWithComments);
        }


        System.out.println(codeWithComments);
    }
}