import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> sizeOfList = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .map(Integer::parseInt).collect(Collectors.toList());
        int numRows = sizeOfList.get(0);
        for(int i = 0; i < numRows; i++) {
            listOfLists.add(Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }

        int numShifts = scanner.nextInt();
        numShifts = numShifts % listOfLists.size();

        for(int i = 0; i < numRows; i++) {
            int index = i-numShifts;
            index = index<0? numRows+index : index;
            listOfLists.get(index).forEach(num-> System.out.print(num+" "));
            System.out.println();
        }
    }
}