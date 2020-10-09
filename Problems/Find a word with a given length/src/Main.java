import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        List<String> isThereAWordWithSize = new ArrayList<>();
        Arrays.stream(line.split("\\b+")).forEach(s-> {
            s = s.trim();
            if(s.length() > 0) {
                String matchText = "[a-zA-Z]+";
                if(s.matches(matchText) && s.length() == size) {
                    isThereAWordWithSize.add("YES");
                    return;
                }
            }
        });
        if(isThereAWordWithSize.size() > 0)
            System.out.println(isThereAWordWithSize.get(0));
        else
            System.out.println("NO");

        // write your code here
    }
}