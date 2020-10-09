import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        int lengthOfLongestString = list.stream()
                                    .mapToInt(String::length)
                                    .max().getAsInt();
        String longestString = list.stream()
                                .filter(str->str.length() == lengthOfLongestString )
                                .findFirst().get();
        for(int i = 0; i < list.size(); i++) {
            Collections.replaceAll(list, list.get(i), longestString);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}