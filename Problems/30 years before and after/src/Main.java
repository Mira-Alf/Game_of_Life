import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        LocalDate dateFromString = LocalDate.parse(dateString);
        System.out.println(dateFromString.minusYears(30).toString());
        System.out.println(dateFromString.plusYears(30).toString());
    }
}