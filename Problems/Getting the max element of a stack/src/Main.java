import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackSimulator simulator = new StackSimulator();
        int numInstrucions = scanner.nextInt();
        for(int i=0; i<numInstrucions; i++) {
            String instruction = scanner.next();
            if(instruction.equals("push"))
                instruction += " " + scanner.next();
            simulator.processInstruction(instruction);
        }
    }
}

class StackSimulator {
    private Deque<Integer> integerStack = new ArrayDeque<>();
    private Deque<Integer> maxStack = new ArrayDeque<>();
    private int max = Integer.MIN_VALUE;

    public void processInstruction(String instruction) {
        String[] opValues = instruction.split("\\s+");
        String operation = opValues[0];
        int operand = opValues.length == 2 ? Integer.parseInt(opValues[1]) : -1;
        if(operation.equals("push") && operand == -1) {
            System.out.println("Invalid input");
            return;
        }
        switch(operation) {
            case "push":
                max = operand > max ? operand : max;
                maxStack.addLast(max);
                integerStack.addLast(operand);
                break;
            case "pop":
                integerStack.removeLast();
                maxStack.removeLast();
                max = maxStack.peekLast();
                break;
            case "max":
                System.out.println(maxStack.peekLast());
                break;
        }
        //System.out.println(integerStack);
        //System.out.println(maxStack);
    }
}