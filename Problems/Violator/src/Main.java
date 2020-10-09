import java.util.ArrayList;
import java.util.List;

/**
 * Class to work with
 */
class Violator {

    public static List<Box<? extends Bakery>> defraud() {
        List<Box<? extends Bakery>> boxList = new ArrayList<>();
        Box<Paper> box = new Box<>();
        box.put(new Paper());
        helperPut(boxList, box);
        return boxList;
    }

    public static <T> void helperPut(List<Box<? extends Bakery>> boxList, Box box) {
        boxList.add(box);
    }

}

