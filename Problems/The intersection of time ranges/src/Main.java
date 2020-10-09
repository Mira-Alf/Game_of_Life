import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<LocalTime> times = new ArrayList<>();
        String timesString = scanner.nextLine();
        times.add(LocalTime.parse(timesString.split("\\s+")[0]));
        times.add(LocalTime.parse(timesString.split("\\s+")[1]));

        timesString = scanner.nextLine();
        LocalTime lt1 = LocalTime.parse(timesString.split("\\s+")[0]);
        LocalTime lt2 = LocalTime.parse(timesString.split("\\s+")[1]);
        boolean isThereAnOverlap = false;
        if(lt1.equals(times.get(0)) || lt1.isAfter(times.get(0)))
            isThereAnOverlap = lt1.equals(times.get(1)) || lt1.isBefore(times.get(1));
        if(lt2.equals(times.get(0)) || lt2.isAfter(times.get(0)))
            isThereAnOverlap = lt1.equals(times.get(1)) || lt1.isBefore(times.get(1));
        System.out.println(isThereAnOverlap);
    }
}