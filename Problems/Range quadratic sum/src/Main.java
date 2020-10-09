import java.util.Scanner;
import java.util.stream.*;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {

        return IntStream.range(fromIncl, toExcl).reduce(0,(sum,x)->sum+(x*x));
    }
}

/*class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fromIncl = scanner.nextInt();
        int toExcl = scanner.nextInt();
        System.out.println(QuadraticSum.rangeQuadraticSum(fromIncl, toExcl));
    }
}*/