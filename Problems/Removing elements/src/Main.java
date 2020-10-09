import java.util.*;
import java.util.stream.Collectors;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        return Arrays.stream(str.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        Set<Integer> removeSetItems = new HashSet<>();

        for(int num : set) {
            if(num>10)
                removeSetItems.add(num);
        }
        set.removeAll(removeSetItems);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}