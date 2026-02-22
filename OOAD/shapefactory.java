public class shapefactory {
      public shape createshape (String type) {
        switch (type) {
            case "circle":
                return new circle();
            case "square":
                return new square();
            case "rectangle":
                return new rectangle();
            default:
                return null;

        }
    }
}
