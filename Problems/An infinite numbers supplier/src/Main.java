import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<Integer>() {
            int n = -1;
            @Override
            public Integer get() {
                return ++n;
            }
        };
    }

}

/*public class Main {
    public static void main(String[] args) {
        Supplier<Integer> sup1 = FunctionUtils.getInfiniteRange();
        Supplier<Integer> sup2 = FunctionUtils.getInfiniteRange();

        for(int i = 0; i < 5; i++) {
            System.out.print(sup1.get() + " " + sup2.get() + " ");
        }
    }
}*/