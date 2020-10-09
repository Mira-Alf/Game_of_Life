import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int dayOfYear = scanner.nextInt();

        LocalDate dateFromString = LocalDate.ofYearDay(year, dayOfYear);
        TemporalAdjuster adjuster = TemporalAdjusters.firstDayOfMonth();
        LocalDate firstDayOfMonth = dateFromString.with(adjuster);
        if(firstDayOfMonth.toString().equals(dateFromString.toString()))
            System.out.println(true);
        else
            System.out.println(false);
    }
}