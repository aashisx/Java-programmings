public class mainshape {
    public static void main(String[] args) {
        shapefactory factory = new shapefactory();
        shape myShape = factory.createshape("circle");
        myShape.draw();
    }
}
