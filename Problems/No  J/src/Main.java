import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void processIterator(String[] array) {
        List<String> strings = Arrays.stream(array).collect(Collectors.toList());
        Iterator<String> listIterator = strings.listIterator();
        while(listIterator.hasNext()) {
            String item = listIterator.next();
            if(!item.startsWith("J"))
                listIterator.remove();
        }
        strings = strings.stream().map(str->str.substring(1)).collect(Collectors.toList());
        Collections.reverse(strings);
        strings.forEach(System.out::println);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}