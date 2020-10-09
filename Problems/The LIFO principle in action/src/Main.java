import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numItems = Integer.parseInt(scanner.nextLine());
        Deque<Integer> dequeList = new ArrayDeque<>();
        for(int i = 0; i < numItems; i++) {
            dequeList.offerFirst(Integer.parseInt(scanner.nextLine()));
        }
        for(int i = 0; i < numItems; i++) {
            System.out.println(dequeList.pollFirst());
        }
    }
}