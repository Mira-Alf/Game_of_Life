import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfDates = Integer.parseInt(scanner.nextLine());
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime latest = localDateTime;
        int count = 1;
        while(count < numOfDates) {
            localDateTime = LocalDateTime.parse(scanner.nextLine());
            if(latest.isBefore(localDateTime))
                latest = localDateTime;
            count++;
        }
        System.out.println(latest.toString());
    }
}