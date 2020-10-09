import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int offsetDifference = scanner.nextInt()-1;


        int monthLength = LocalDate.of(year, month, 1).lengthOfMonth();
        System.out.println(LocalDate.of(year, month, monthLength-offsetDifference));

    }
}