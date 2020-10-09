import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> dictionary = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .collect(Collectors.toList());
        Map<String, Integer> dictionaryMap = new HashMap<>();
        dictionary.forEach(word-> {
             dictionaryMap.put(word, !dictionaryMap.containsKey(word) ? 1 : dictionaryMap.put(word, dictionaryMap.get(word)+1) );
        });

        String blackMailLine = scanner.nextLine();
        boolean canSendLetter = true;
        for(String s : blackMailLine.split("\\s+")) {
            if(!dictionaryMap.containsKey(s) || dictionaryMap.get(s)==0) {
                canSendLetter = false;
                break;
            }
            dictionaryMap.put(s, dictionaryMap.get(s)-1);
        }
        System.out.println(canSendLetter ? "You get money" : "You are busted");

    }
}