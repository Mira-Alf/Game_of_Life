import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Sum {
    public static int sumOfAreas(Shape[] array) {
        List<Integer> sumOfAreas = new ArrayList<>();
        sumOfAreas.add(0,0);
        Map<Class, List<Shape>> shapesMap = Arrays.stream(array)
                .collect(Collectors.groupingBy(s->s.getClass(), Collectors.toList()));
        if(shapesMap.get(Square.class) != null)
            shapesMap.get(Square.class).stream().forEach(s->{
                int sumA = sumOfAreas.get(0);
                Square square = (Square)s;
                sumA += (square.getSide()*square.getSide());
                sumOfAreas.set(0, sumA);
            });
        if(shapesMap.get(Rectangle.class) != null)
            shapesMap.get(Rectangle.class).stream().forEach(r->{
                int sumA = sumOfAreas.get(0);
                Rectangle rect = (Rectangle)r;
                sumA += (rect.getWidth()*rect.getHeight());
                sumOfAreas.set(0, sumA);
            });
        return sumOfAreas.get(0);
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}