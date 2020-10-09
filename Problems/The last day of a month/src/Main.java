import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int dayOfYear = scanner.nextInt();

        LocalDate dateFromInput = LocalDate.ofYearDay(year, dayOfYear);
        int monthDay = dateFromInput.getDayOfMonth();
        Month month = dateFromInput.getMonth();
        boolean isLastDayOfMonth = false;
        switch(month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                isLastDayOfMonth = monthDay == 31;
                break;
            case FEBRUARY:
                isLastDayOfMonth = dateFromInput.isLeapYear() ? monthDay == 29 : monthDay == 28;
                break;
            default:
                isLastDayOfMonth = monthDay == 30;
        }
        System.out.println(isLastDayOfMonth);
    }
}