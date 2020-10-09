import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 Check whether the class declares public parameterless constructor
 */
class ConstructorChecker {

    public boolean checkPublicParameterlessConstructor(Class<?> clazz) {
        List<Constructor<?>> constructorList = Arrays.stream(clazz.getConstructors())
                                            .filter(c->c.getParameterCount() == 0)
                                            .collect(Collectors.toList());
        if(constructorList.size() == 0)
            return false;
        else return true;
    }

}