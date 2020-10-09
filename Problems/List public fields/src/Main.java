import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 Get list of public fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public String[] getPublicFields(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(f-> f.getModifiers() == Modifier.PUBLIC)
                .map(f->f.getName())
                .collect(Collectors.toList()).toArray(new String[0]);

    }

}

/*public class Main {
    public static void main(String[] args) {
        String value = "myStr";
        FieldGetter getter = new FieldGetter();
        System.out.println(Arrays.toString(getter.getPublicFields(value)));
    }
}*/