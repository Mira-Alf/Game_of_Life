import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];
        int count = 0, boxes = 0;
        do {
            do {
                if(boxes == 0)
                    box1[count++] = scanner.nextInt();
                else
                    box2[count++] = scanner.nextInt();
            } while (count < 3);
            count = 0;
            boxes++;
        } while(boxes < 2);
        Arrays.sort(box1);
        Arrays.sort(box2);
        boolean boxesNotCompatible = box1[0] == box2[0];
        boolean isBox1Bigger = box1[0] > box2[0];
        boolean isBox2Bigger = !isBox1Bigger;
        for(int i = 1; i < 3; i++) {
            boxesNotCompatible = boxesNotCompatible || (box1[i] == box2[i]);
            if(!boxesNotCompatible) {
                isBox1Bigger = isBox1Bigger && (box1[i] > box2[i]);
                isBox2Bigger = isBox2Bigger && (box1[i] < box2[i]);
            }
        }
        if(boxesNotCompatible)
            System.out.println("Incompatible");
        else if(isBox1Bigger)
            System.out.println("Box 1 > Box 2");
        else if(isBox2Bigger)
            System.out.println("Box 1 < Box 2");

    }
}