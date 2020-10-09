import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>();
        Arrays.stream(strings).forEach(s->{
            map.put(s, !map.containsKey(s) ? 1 : map.get(s)+1);
        });
        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((key, value)-> System.out.println(key+" : "+value));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}