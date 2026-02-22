class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        super.sound();
        System.out.println("Dog barks");
    }
}

public class TestAnimalSound {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
}

