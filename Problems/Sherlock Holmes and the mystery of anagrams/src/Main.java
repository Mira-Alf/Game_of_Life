import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static boolean areAnagrams(String input, String anagram) {
        if(input.length() != anagram.length())
            return false;

        LinkedHashMap<String, Integer> inputMap = getHashMap(input);
        LinkedHashMap<String, Integer> anagramMap = getHashMap(anagram);
        for(String key : inputMap.keySet()) {
            if(!anagramMap.containsKey(key) || (inputMap.get(key) != anagramMap.get(key)) )
                return false;
        }
        return true;
    }

    public static LinkedHashMap<String, Integer> getHashMap(String input) {
        LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>();
        input.chars().forEach(ch->linkedMap.put(String.valueOf((char)ch),
            !linkedMap.containsKey(String.valueOf((char)ch)) ? 1 :
                    linkedMap.get(String.valueOf((char)ch))+1));
        return linkedMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        String anagram = scanner.nextLine().toLowerCase();
        System.out.println(areAnagrams(input, anagram) ? "yes" : "no");
    }
}