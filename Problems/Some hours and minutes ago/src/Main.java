import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String timeString = scanner.nextLine();
        int beforeHours = scanner.nextInt();
        int beforeMinutes = scanner.nextInt();

        LocalTime timeFromString = LocalTime.parse(timeString);
        int seconds = timeFromString.toSecondOfDay() - ((beforeHours*60*60)+(beforeMinutes*60));
        System.out.println(LocalTime.ofSecondOfDay(seconds));
    }
}