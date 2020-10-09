import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate localDateX = LocalDate.parse(scanner.next());
        LocalDate localDateM = LocalDate.parse(scanner.next());
        LocalDate localDateN = LocalDate.parse(scanner.next());

        if(localDateM.isEqual(localDateN) ||
                localDateM.isEqual(localDateX) ||
                localDateN.isEqual(localDateX))
            System.out.println(false);
        else {
            if(localDateX.isAfter(localDateM) && localDateX.isBefore(localDateN))
                System.out.println(true);
            else if(localDateX.isAfter(localDateN) && localDateX.isBefore(localDateM))
                System.out.println(true);
            else
                System.out.println(false);
        }



    }
}