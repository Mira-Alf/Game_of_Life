import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int closeTo = scanner.nextInt();
        int smallestDifference = numbers.stream().mapToInt(num->Math.abs(num-closeTo)).min().getAsInt();
        numbers.stream()
                .filter(num->closeTo+smallestDifference==num || closeTo-smallestDifference==num)
                .sorted().forEach(num-> System.out.print(num+" "));

    }
}