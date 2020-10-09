import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String timeString = scanner.nextLine();
        LocalTime timeFromString = LocalTime.parse(timeString);
        System.out.println(LocalTime.of(timeFromString.getHour(), timeFromString.getMinute()));
    }
}