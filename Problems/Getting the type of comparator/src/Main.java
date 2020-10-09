import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to work with
 */
class ComparatorInspector {

    /**
     * Return Type variable that corresponds to the type parameterizing Comparator.   
     *
     * @param clazz {@link Class} object, should be non null
     * @return {@link Type} object or null if Comparable does not have type parameter
     */
    public static <T extends Comparable<?>> Type getComparatorType(Class<T> clazz){

        List<Type> interfaceNames = Arrays.stream(clazz.getGenericInterfaces())
                            .filter(type -> type.getTypeName().startsWith("java.lang.Comparable"))
                            .collect(Collectors.toList());
        if(interfaceNames.size() == 0)
            return null;
        //Type interfaceName = clazz.getGenericInterfaces()[0];
        Type interfaceName = interfaceNames.get(0);
        Type result = null;
        if(interfaceName instanceof ParameterizedType) {
            result = ((ParameterizedType)interfaceName).getActualTypeArguments()[0];
        }
        return result;
    }

}

/*class MyInt implements Comparable<Integer> {

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}

class MyStr implements Serializable {

}

public class Main {
    public static void main(String[] args) {
        ComparatorInspector.getComparatorType(MyInt.class);
        //ComparatorInspector.getComparatorType(MyStr.class);
    }
}*/