import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> map = new HashMap<>();
        String[] ranges = scanner.nextLine().split("\\s+");
        int fromRange = Integer.parseInt(ranges[0]),
                toRange = Integer.parseInt(ranges[1]);

        int numKeyPairs = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numKeyPairs; i++) {
            String[] inputs = scanner.nextLine().split("\\s+");
            map.put(Integer.parseInt(inputs[0]), inputs[1]);
        }

        map.keySet().stream()
                .filter(k->k>=fromRange && k<=toRange)
                .sorted()
                .forEach(k-> System.out.println(k+" "+map.get(k)));

    }
}