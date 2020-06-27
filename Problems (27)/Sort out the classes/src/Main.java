import java.util.List;

class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
       for(Shape shape: array) {
           if(shape instanceof Circle) {
               circles.add((Circle) shape);
           }
           else if(shape instanceof  Polygon) {
               if(shape instanceof Square) {
                   squares.add((Square)shape);
               }
               else  {
                   polygons.add((Polygon)shape);
               }
           }
           else {
               shapes.add(shape);
           }
       }
    }
}

//Don't change classes below
class Shape { }
class Polygon extends Shape { }
class Square extends Polygon { }
class Circle extends Shape { }