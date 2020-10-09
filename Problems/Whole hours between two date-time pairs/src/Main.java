import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime localDateTime1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime localDateTime2 = LocalDateTime.parse(scanner.nextLine());
        long seconds = Math.abs(localDateTime1.toEpochSecond(ZoneOffset.UTC)-localDateTime2.toEpochSecond(ZoneOffset.UTC));
        System.out.println(seconds/3600);


    }
}