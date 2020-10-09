import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\bpassword[\\s:]*[\\w]*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        Stream<MatchResult> matchResultStream = matcher.results();

        final Pattern patternToGetPassword = Pattern.compile("\\b[\\w]*\\b");
        List<Integer> numPasswordsList = new ArrayList<>();
        numPasswordsList.add(0,0);


        matchResultStream.forEach(result -> {
                String group = result.group();
                String[] elements = group.split("[:\\s]+");
                System.out.println(elements[1]);
                numPasswordsList.set(0, numPasswordsList.get(0)+1);
        });
        if(numPasswordsList.get(0) == 0)
            System.out.println("No passwords found.");

    }
}