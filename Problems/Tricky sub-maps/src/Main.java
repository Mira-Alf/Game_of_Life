import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        Map<Integer, String> result = new LinkedHashMap<>();
        Integer firstKey = map.keySet().stream().findFirst().get();
        Integer lastKey = map.keySet().stream().sorted((k1,k2)->k2.compareTo(k1)).findFirst().get();
        if(firstKey != null) {
            if(firstKey%2 != 0)
                map.keySet().stream()
                        .filter(k->k>=firstKey&&k<=firstKey+4)
                        .sorted((k1,k2)->k2.compareTo(k1))
                        .forEach(k->result.put(k, map.get(k)));
            else
                map.keySet().stream()
                        .filter(k->k>=lastKey-4 && k<=lastKey)
                        .sorted((k1,k2)->k2.compareTo(k1))
                        .forEach(k->result.put(k, map.get(k)));
        }
        return result;
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}