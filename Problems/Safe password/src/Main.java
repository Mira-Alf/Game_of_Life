import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passwordString = scanner.nextLine();

        String digitRegEx = "[0-9]";
        String lowerCaseRegex = "[a-z]";
        String upperCaseRegex = "[A-Z]";
        int[] passwordStatistics = new int[] {0, 0, 0};

        boolean matches = passwordString.length() >= 12 ? true : false;
        for(int i = 1; i < passwordString.length(); i++) {
            String subS = passwordString.substring(i-1,i);
            if(subS.matches(digitRegEx))
                passwordStatistics[0]++;
            else if(subS.matches(lowerCaseRegex))
                passwordStatistics[1]++;
            else if(subS.matches(upperCaseRegex))
                passwordStatistics[2]++;
        }
        matches = matches && (passwordStatistics[0] != 0 &&
                passwordStatistics[1] != 0 &&
                passwordStatistics[2] != 0);
        System.out.println(matches ? "YES" : "NO");
    }
}