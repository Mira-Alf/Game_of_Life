import java.util.function.*;

class Operator {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        Function<T, U> function = (T term1) ->
            condition.test(term1) ? ifTrue.apply(term1) : ifFalse.apply(term1);
        return function;

    }
}