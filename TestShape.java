class Shape {
    void area() {
        System.out.println("Area of shape");
    }
}

class Circle extends Shape {
    @Override
    void area() {
        System.out.println("Area of circle = π × r × r");
    }
}

class Rectangle extends Shape {
    @Override
    void area() {
        System.out.println("Area of rectangle = length × breadth");
    }
}

public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        s1.area();

        Shape s2 = new Rectangle();
        s2.area();
    }
}

