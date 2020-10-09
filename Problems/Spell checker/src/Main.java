import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numWordsInDictionary = Integer.parseInt(scanner.nextLine());
        Set<String> dictionary = new HashSet<>();
        for(int i = 0; i < numWordsInDictionary; i++) {
            dictionary.add(scanner.nextLine().toLowerCase());
        }
        int numLines = Integer.parseInt(scanner.nextLine());
        Set<String> textWords = new HashSet<>();
        for(int i = 0; i < numLines; i++) {
            textWords.addAll(Arrays.stream(scanner.nextLine().toLowerCase()
                    .split("\\s+"))
                    .collect(Collectors.toSet()));
        }
        textWords.removeIf(str->dictionary.contains(str));
        textWords.forEach(System.out::println);
    }
}