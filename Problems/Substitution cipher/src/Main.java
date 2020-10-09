import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static Map<String, String> encoderMap = new HashMap<>();
    public static Map<String, String> decoderMap = new HashMap<>();

    public static void createMap(String inputLine, String encodedLine) {
        if(inputLine.length() != encodedLine.length()) {
            System.out.println("Invalid input");
            return;
        }
        int index = 0;
        for(char ch : inputLine.toCharArray()) {
            encoderMap.put(String.valueOf((char) ch),
                    String.valueOf(encodedLine.charAt(index)));
            decoderMap.put(String.valueOf(encodedLine.charAt(index)), String.valueOf(ch));
            index++;
        }
    }

    public static String encryptLine(String inputLine) {
        String result = "";
        for(char ch : inputLine.toCharArray())
            result += encoderMap.get(String.valueOf(ch));
        return result;
    }

    public static String decryptLine(String encodedLine) {
        String result = "";
        for(char ch : encodedLine.toCharArray())
            result += decoderMap.get(String.valueOf(ch));
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createMap(scanner.nextLine(), scanner.nextLine());
        System.out.println(encryptLine(scanner.nextLine())+"\n"+decryptLine(scanner.nextLine()));
    }
}