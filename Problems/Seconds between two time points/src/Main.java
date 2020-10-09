import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String timeString1 = scanner.nextLine();
        String timeString2 = scanner.nextLine();

        System.out.println(Math.abs(LocalTime.parse(timeString1)
                .toSecondOfDay()
                -LocalTime.parse(timeString2)
                .toSecondOfDay()));
    }
}