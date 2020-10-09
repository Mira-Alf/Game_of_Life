import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (x,y)-> {
        if(x==y)
            return x;
        else {
            long lower = x < y ? x : y, upper =x < y ? y : x;
            long prod = 1;
            for(long i = lower; i <= upper; i++) {
                prod *= i;
            }
            return prod;
        }
    };
}