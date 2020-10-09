import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        int numItems = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numItems; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            if(element%2 == 0)
                deque.offerFirst(element);
            else
                deque.offerLast(element);
        }
        for(int i = 0; i < numItems; i++) {
            System.out.println(deque.pollFirst());
        }

    }
}