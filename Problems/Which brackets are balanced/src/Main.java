import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Stack<String> symbolsStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String symbolsLine = scanner.nextLine();
        boolean areBracketsInHierarchy = true;
        for(char c : symbolsLine.toCharArray()) {
            if(isOpeningSymbol(c))
                symbolsStack.push(String.valueOf(c));
            else{
                if(symbolsStack.isEmpty() || c != getMatchingCharacter(symbolsStack.peek().charAt(0))) {
                    areBracketsInHierarchy = false;
                    break;
                } else
                    symbolsStack.pop();
            }
        }

        System.out.println(areBracketsInHierarchy?(symbolsStack.isEmpty()?true:false):false);
    }

    public static boolean isOpeningSymbol(char ch) {
        switch(ch) {
            case '(':
            case '[':
            case '{':
                return true;
            default:
                return false;
        }
    }

    public static char getMatchingCharacter(char ch) {
        switch(ch) {
            case '(':
                return ')';
            case ')':
                return '(';
            case '[':
                return ']';
            case ']':
                return '[';
            case '{':
                return '}';
            case '}':
                return '{';
        }
        return ch;
    }
}