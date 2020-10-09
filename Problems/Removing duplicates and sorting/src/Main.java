import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numItems = Integer.parseInt(scanner.nextLine());
        Set<String> setItems = new TreeSet<>();
        for(int i = 0; i < numItems; i++) {
            setItems.add(scanner.nextLine());
        }
        setItems.forEach(System.out::println);
    }
}