import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(str->str.toLowerCase())
                .forEach(str->{
            map.put(str, !map.containsKey(str) ? 1: map.get(str)+1);
        });
        map.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }
}