import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime range1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime range2 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime earlier = range1.isBefore(range2) ? range1 : range2;
        LocalDateTime later = range1.isAfter(range2) ? range1 : range2;


        int numDates = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int result = 0;
        while(count < numDates) {
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
            if(!earlier.isEqual(later)) {
                if ((dateTime.isAfter(earlier) || dateTime.isEqual(earlier))
                        && dateTime.isBefore(later))
                    result++;
            }
            count++;
        }
        System.out.println(result);
    }
}