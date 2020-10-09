import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime now = LocalTime.of(19, 30);
        int numRestaurants = Integer.parseInt(scanner.nextLine());
        int count = 0;
        List<String> ffChains = new ArrayList<>();
        while(count < numRestaurants) {
            String ffChain = scanner.nextLine();
            LocalTime localTime = LocalTime.parse(ffChain.split("\\s+")[1]);
            if(now.plusMinutes(30).isBefore(localTime))
                ffChains.add(ffChain.split("\\s+")[0]);
            count++;
        }
        ffChains.forEach(System.out::println);
    }
}