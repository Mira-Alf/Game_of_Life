import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> removeNumbers = new ArrayList<>();

        for(int i = 0; i < numbers.size(); i++) {
            Integer element = numbers.get(i);

            if(i == 0 || (i%2==0))
                removeNumbers.add(element);
        }
        numbers.removeAll(removeNumbers);
        Collections.reverse(numbers);
        numbers.forEach(num-> System.out.print(num+" "));
    }
}