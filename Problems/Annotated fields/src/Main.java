
/**
 Get an array of fields the object declares that contain annotations (inherited fields should be skipped).
 */
class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {
        return java.util.Arrays.stream(object.getClass().getDeclaredFields())
                .filter(f->f.getDeclaredAnnotations().length > 0)
                .map(f->f.getName())
                .collect(java.util.stream.Collectors.toList()).toArray(new String[0]);
    }

}