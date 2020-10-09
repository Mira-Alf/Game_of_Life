import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int findMaxByIterator(Iterator<Integer> iterator) {
        List<Integer> list = new ArrayList<>();
        while(iterator.hasNext()) {
            list.add(iterator.next());
        }

        return list.stream()
                .sorted((item1, item2)->item2.compareTo(item1))
                .findFirst().get();
    }

    /* Do not change code below */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(findMaxByIterator(list.iterator()));
    }
}