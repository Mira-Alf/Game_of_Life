import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeString = scanner.nextLine();
        int beforeHours = scanner.nextInt();
        int afterMinutes = scanner.nextInt();

        LocalDateTime localDateTimeFromString = LocalDateTime.parse(dateTimeString);
        System.out.println(localDateTimeFromString.minusHours(beforeHours).plusMinutes(afterMinutes));
    }
}