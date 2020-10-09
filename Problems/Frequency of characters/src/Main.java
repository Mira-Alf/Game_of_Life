import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .collect(Collectors.toList());
        String element = scanner.next();
        System.out.println(Collections.frequency(inputs, element));
    }
}