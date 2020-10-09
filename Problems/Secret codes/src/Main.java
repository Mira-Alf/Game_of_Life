import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static List<String> extractCodes(List<String> codes) {
        final String matchBeginning = "#0000";
        final String matchEnding = "#FFFF";
        return codes.stream()
                .dropWhile(code->!code.equals(matchBeginning))
                .takeWhile(code->!code.equals(matchEnding))
                .filter(code->!code.equals(matchBeginning))
                .collect(Collectors.toList());

    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> codes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        System.out.println(String.join(" ", extractCodes(codes)));
    }
}