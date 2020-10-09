import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] levels = scanner.nextLine().split("\\s+");
        int sumOfLogLevels = Arrays.stream(levels)
                .map(String::toUpperCase)
                .mapToInt(name-> Level.parse(name).intValue())
                .sum();
        System.out.println(sumOfLogLevels);
    }
}