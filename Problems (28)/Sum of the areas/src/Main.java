class Sum {
    public static int sumOfAreas(Shape[] array) {
        int area = 0;
        for(Shape shape: array) {
            if(shape instanceof Square) {
                Square square = (Square) shape;
                area += square.getSide() * square.getSide();
            }
            else if(shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                area += rectangle.getHeight() * rectangle.getWidth();
            }
        }
        return area;
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