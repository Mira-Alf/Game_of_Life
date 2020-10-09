import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
        Matcher wordMatcher = wordPattern.matcher(inputLine);
        List<String> words = wordMatcher.results()
                .map(result->result.group()).collect(Collectors.toList());
        Map<String, Integer> wordsMap = new HashMap<>();
        words.stream().map(String::toLowerCase)
                .forEach(w->wordsMap.put(w, !wordsMap.containsKey(w) ? 1: wordsMap.get(w)+1 ));
        List<Integer> frequencyList = wordsMap.keySet().stream()
                .sorted((e1,e2)->wordsMap.get(e2).compareTo(wordsMap.get(e1)))
                .map(e->wordsMap.get(e))
                .distinct()
                .collect(Collectors.toList());
        frequencyList.stream()
                .flatMap(num->wordsMap.keySet().stream().filter(e->wordsMap.get(e) == num).sorted())
                .limit(10)
                .forEach(System.out::println);


    }
}