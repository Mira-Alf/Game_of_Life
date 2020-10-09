import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        Pattern beginPattern = Pattern.compile(part+"$", Pattern.CASE_INSENSITIVE);
        Pattern endPattern = Pattern.compile("^"+part, Pattern.CASE_INSENSITIVE);
        Matcher beginMatcher = null;
        Matcher endMatcher = null;
        boolean matches = false;
        for(String l : line.split("\\b+")) {
            beginMatcher = beginPattern.matcher(l);
            endMatcher = endPattern.matcher(l);
            matches = beginMatcher.find() || endMatcher.find();
            if(matches)
                break;
        }
        System.out.println(matches ? "YES" : "NO");
    }
}