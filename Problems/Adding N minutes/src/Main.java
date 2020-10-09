import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());
        int minutes = scanner.nextInt();
        localDateTime = localDateTime.plusMinutes(minutes);
        System.out.printf("%d %d", localDateTime.getYear(), localDateTime.getDayOfYear());
        System.out.printf(localDateTime.getHour() <=9 ? " 0%d" : " %d", localDateTime.getHour());
        System.out.printf(localDateTime.getMinute() <=9 ? ":0%d" : ":%d", localDateTime.getMinute());

        System.out.printf(localDateTime.getSecond() > 0 ?
                (localDateTime.getSecond() <= 9 ? ":0%d%n" : ":%d") : "", localDateTime.getSecond());
    }
}