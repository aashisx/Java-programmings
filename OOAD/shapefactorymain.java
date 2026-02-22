public class shapefactorymain {
    public static void main(String[] args) {
        shapefactory factory = new shapefactory();
        
        shape circle = factory.createshape("circle");
        shape square = factory.createshape("square");
        shape rectangle = factory.createshape("rectangle");
        
        circle.draw();
        square.draw();
        rectangle.draw();
    }
}