import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> originalList = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        List<Integer> subList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.print(Collections.indexOfSubList(originalList, subList)+" ");
        System.out.println(Collections.lastIndexOfSubList(originalList, subList));
    }
}