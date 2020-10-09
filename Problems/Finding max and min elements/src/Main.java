import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());
        System.out.println(list.size());
        T min = null, max = null;
        if(list.size() > 0) {
            min = list.get(0);
            max = list.get(list.size()-1);
        }
        minMaxConsumer.accept(min, max);

    }
}