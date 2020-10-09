import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        int offset = Integer.parseInt(scanner.nextLine());

        LocalDate dateFromString = LocalDate.parse(dateString);
        int year = dateFromString.getYear();
        while(dateFromString.getYear() == year) {
            System.out.println(dateFromString.toString());
            dateFromString = dateFromString.plusDays(offset);
        }
    }
}