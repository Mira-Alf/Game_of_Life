import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate dateFromString = LocalDate.parse(scanner.next());
        dateFromString = dateFromString.plusDays(scanner.nextInt());
        System.out.println(dateFromString.with(TemporalAdjusters.firstDayOfYear()).isEqual(dateFromString));
    }
}