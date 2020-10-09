import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        if(Collections.frequency(list1, elem) == Collections.frequency(list2, elem))
            return true;
        return false;
    }
}

/*public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numToCheck = Integer.parseInt(scanner.nextLine());

        List<Integer> list1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(Counter.checkTheSameNumberOfTimes(numToCheck, list1, list2));
    }
}*/