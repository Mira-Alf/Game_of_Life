import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


class Operator {

    public static UnaryOperator<List<String>> unaryOperator = stringList->{
        return stringList.stream().distinct().collect(Collectors.toList());
    };
}