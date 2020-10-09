import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        Map<Class, List<Shape>> shapesMap = java.util.Arrays.stream(array)
                .collect(Collectors.groupingBy(s->s.getClass(), Collectors.toList()));
        if(shapesMap.get(Shape.class) != null)
            shapesMap.get(Shape.class).stream().forEach(s->shapes.add(s));
        if(shapesMap.get(Polygon.class) != null)
            shapesMap.get(Polygon.class).stream().forEach(s->polygons.add((Polygon)s));
        if(shapesMap.get(Square.class) != null)
            shapesMap.get(Square.class).stream().forEach(s->squares.add((Square)s));
        if(shapesMap.get(Circle.class) != null)
            shapesMap.get(Circle.class).stream().forEach(s->circles.add((Circle)s));

                /*.forEach(s->{
            if(s instanceof Polygon) {
                if(s instanceof Square)
                    squares.add((Square)s);
                else polygons.add((Polygon)s);
            } else if(s instanceof Shape) {
                if(s instanceof Circle)
                    circles.add((Circle)s);
                else
                    shapes.add(s);
            }
        });*/
    }
}

//Don't change classes below
class Shape { }
class Polygon extends Shape { }
class Square extends Polygon { }
class Circle extends Shape { }