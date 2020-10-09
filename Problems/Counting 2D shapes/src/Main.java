import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Counter {
    public static int count2DShapes(Shape[] shapes) {
        List<Integer> numOf2DShapes = new ArrayList<>();
        numOf2DShapes.add(0,0);

        Arrays.stream(shapes).forEach(s-> {
            if(s instanceof Shape2D && s.getClass() != Shape2D.class) {
                numOf2DShapes.set(0, numOf2DShapes.get(0)+1);
            }
        });
        return numOf2DShapes.get(0);
    }
}

// Don't change the code below

class Shape {
}

class Shape2D extends Shape {
}

class Shape3D extends Shape {
}


class Circle extends Shape2D {
}

class Shape2DSub1 extends Shape2D {
}

class Shape2DSub2 extends Shape2D {
}


class Cube extends Shape3D {
}

class Shape3DSub1 extends Shape3D {
}

class Shape3DSub2 extends Shape3D {
}