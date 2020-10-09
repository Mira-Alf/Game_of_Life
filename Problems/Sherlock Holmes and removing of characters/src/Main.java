import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

    public static Map<String, Integer> getHashMap(String input) {
        Map<String, Integer> map = new HashMap<>();
        input.chars().forEach(ch->map.put(String.valueOf((char)ch),
                !map.containsKey(String.valueOf((char)ch)) ? 1 :
                        map.get(String.valueOf((char)ch))+1));
        return map;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.nextLine().toLowerCase();
        String secondWord = scanner.nextLine().toLowerCase();
        Map<String, Integer> firstWordMap = getHashMap(firstWord);
        Map<String, Integer> secondWordMap = getHashMap(secondWord);
        long numCharsInFirstWordButNotInSecond = firstWordMap.keySet()
                .stream().filter(k->!secondWordMap.containsKey(k))
                .mapToInt(k->firstWordMap.get(k))
                .sum();
        long numCharsInSecondWordButNotInFirst = secondWordMap.keySet().stream()
                .filter(k->!firstWordMap.containsKey(k))
                .mapToInt(k->secondWordMap.get(k))
                .sum();
        long numExcessCharsInFirstWordOrSecondWord = firstWordMap.keySet().stream()
                .filter(k->secondWordMap.containsKey(k))
                .mapToInt(k->Math.abs(firstWordMap.get(k)-secondWordMap.get(k)))
                .sum();
        System.out.println(numCharsInFirstWordButNotInSecond+numCharsInSecondWordButNotInFirst+numExcessCharsInFirstWordOrSecondWord);


    }
}