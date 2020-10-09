import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class QualityControl {

    public static boolean check(List<?> boxes) {
        if(boxes.size() == 0)
            return true;
        boolean testFail = false;
        if(!testFail) {
            long notBoxes = boxes.stream().filter(box -> !(box instanceof Box)).count();
            testFail = notBoxes > 0;
        }
        if(!testFail) {
            long nullBoxes = boxes.stream().filter(box -> box == null ||
                    (box != null && ((Box) box).get() == null))
                    .count();
            testFail = nullBoxes > 0;
        }

        if(!testFail) {
            long invalidBoxes = boxes.stream().filter(box -> box != null && ((Box) box).get() != null
                    && !(((Box) box).get() instanceof Bakery))
                    .count();
            testFail = invalidBoxes > 0;
        }
        return !testFail;
    }

}

/*public class Main {
    public static void main(String[] args) {
        Box<Tart> box = new Box<>();
        box.put(new Tart());
        Box<Paper> paperBox = new Box<>();
        paperBox.put(new Paper());
        Box<Cake> cakeBox = null;
        List<Box<?>> boxesList = new ArrayList<>();
        boxesList.add(box);
        boxesList.add(paperBox);
        boxesList.add(cakeBox);
        System.out.println(QualityControl.check(boxesList));
    }
}*/

// Don't change the code below
class Bakery { }

class Cake extends Bakery { }

class Pie extends Bakery { }

class Tart extends Bakery { }

class Paper { }

class Box<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}