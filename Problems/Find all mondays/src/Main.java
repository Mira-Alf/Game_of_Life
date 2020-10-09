import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();

        TemporalAdjuster adjusters = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        LocalDate firstMonday = LocalDate.of(year, month, 1).with(adjusters);
        while(firstMonday.getMonthValue() == month
                && firstMonday.getYear() == year) {
            System.out.println(firstMonday.toString());
            firstMonday = firstMonday.plusWeeks(1);
        }

    }
}