import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static <T> boolean isStrictSuperset(Set<T> set1, Set<T> set2) {
        for(T elem : set1) {
            if(!set2.contains(elem))
                return false;
        }
        return set1.size() != set2.size();
    }

    /* Please do not change the code below */
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        Set<String> set1 = readStringSet(scanner);
        Set<String> set2 = readStringSet(scanner);

        System.out.println(isStrictSuperset(set1, set2));*/
        Deque<Integer> deq = new LinkedList<>();
        deq.offerFirst(10);
        deq.peekFirst();
        deq.offerFirst(20);
        deq.offerLast(30);
        deq.peekLast();
        deq.pollFirst();
        deq.offerLast(40);
        System.out.println(deq);

    }

    private static Set<String> readStringSet(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toSet());
    }
}