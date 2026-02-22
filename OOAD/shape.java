public interface shape {
    void draw();
}

class square implements shape {

    @Override
    public void draw() {
        System.out.println(" Making square");
    }
}
 class circle implements shape {

    @Override
    public void draw() {
        System.out.println(" Making circle");
    }
}

 class rectangle implements shape {

    @Override
    public void draw() {
        System.out.println(" Making rectangle");
    }
}
