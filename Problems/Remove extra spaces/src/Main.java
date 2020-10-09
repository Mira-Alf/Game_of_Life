import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RemoveExtraSpacesProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String pattern = "\\s+";
        Pattern emptySpace = Pattern.compile(pattern);
        Matcher matcher = emptySpace.matcher(text);
        String result = matcher.replaceAll(" ");
        System.out.println(result);
    }
}