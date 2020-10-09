import java.util.*;

public class Main {

    public static boolean matchesDigitsSeparatedByThreeDigits(String ipString) {
        String matchDotRegex = "\\.";
        String matchAnyDigit = "\\d+";
        String regexPattern = matchAnyDigit + matchDotRegex + matchAnyDigit + matchDotRegex
                            + matchAnyDigit + matchDotRegex + matchAnyDigit;

        return ipString.matches(regexPattern);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipString = scanner.nextLine();

        boolean matchesResult = matchesDigitsSeparatedByThreeDigits(ipString);
        if(matchesResult) {
            String[] ipNumbers = ipString.split("\\.");
            final List<Boolean> resultBoolean = new ArrayList<>();
            Arrays.stream(ipNumbers).forEach(num -> {
                Integer number = Integer.parseInt(num);
                if(num.length()>1 && num.startsWith("0"))
                    resultBoolean.add(false);
                else if(number>=0 && number<=255)
                    resultBoolean.add(true);
                else
                    resultBoolean.add(false);
            });
            for(boolean r : resultBoolean) {
                matchesResult &= r;
            }
        }
        System.out.println(matchesResult ? "YES" : "NO");
    }
}