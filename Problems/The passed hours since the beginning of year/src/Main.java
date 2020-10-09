import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime yearBeginning = LocalDateTime.of(localDateTime.getYear(), 1, 1, 0, 0, 0);
        System.out.println((localDateTime.toEpochSecond(ZoneOffset.UTC) - yearBeginning.toEpochSecond(ZoneOffset.UTC))/3600);

    }
}