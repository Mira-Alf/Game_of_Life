import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) {
        List<String> selectedClasses = new ArrayList<>();
        Arrays.stream(classNames).forEach(c->{
            try {
                List<String> methods = Arrays.stream(Class.forName(c).getMethods())
                                        .map(m->m.getName())
                                        .collect(Collectors.toList());
                if(methods.contains(methodName))
                    selectedClasses.add(c);
            } catch(ClassNotFoundException ce) {
                System.out.println("Exception "+ce.getMessage());
            }
        });
        return selectedClasses.size() == 0 ? null : selectedClasses.get(0);
    }
}

public class Main {
    public static void main(String[] args) {
        /*System.out.println(MethodFinder
                .findMethod("abs", new String[]{"java.lang.String",
                        "java.lang.StringBuffer", "java.lang.Math"}));*/
        System.out.println(double[][][][].class.getName());

    }
}