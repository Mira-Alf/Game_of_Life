import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int count = 0;
        do {
            System.out.println(LocalDate.ofYearDay(year, scanner.nextInt()));
            count++;
        } while(count < 3);
    }
}