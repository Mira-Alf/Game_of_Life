import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        List<Field> fieldOptional = Arrays.stream(object.getClass().getFields())
                .filter(f->f.getName().equals(fieldName))
                .collect(Collectors.toList());
        Field field = fieldOptional.size() == 0 ? null : fieldOptional.get(0);
        return field == null ? null : field.get(object);
    }

}