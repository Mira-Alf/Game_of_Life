import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt).collect(Collectors.toList());
        int numSwaps = scanner.nextInt(), counter = 0;
        while(counter<numSwaps) {
            int fromIndex = scanner.nextInt();
            int toIndex = scanner.nextInt();
            Collections.swap(numbers, fromIndex, toIndex);
            counter++;
        }
        numbers.forEach(num-> System.out.print(num+" "));
    }
}