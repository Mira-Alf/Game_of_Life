import java.util.Arrays;
import java.util.stream.Collectors;

class Seven {

    public static MultipleArgumentsLambda.SeptenaryStringFunction fun =
            (String a,String b,String c,String d,String e,String f,String g)-> {
                return a.toUpperCase()+b.toUpperCase()+c.toUpperCase()+
                        d.toUpperCase()+e.toUpperCase()+
                        f.toUpperCase() + g.toUpperCase();
            };
}