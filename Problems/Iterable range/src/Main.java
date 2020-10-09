import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Range implements Iterable<Long> {

    private long fromInclusive;
    private long toExclusive;

    public Range(long from, long to) {
        this.fromInclusive = from;
        this.toExclusive = to;
    }

    @Override
    public Iterator<Long> iterator() {
        List<Long> longList = new ArrayList<>();
        for(long i = fromInclusive; i<toExclusive; i++) {
            longList.add(i);
        }
        return longList.iterator();
    }
}
