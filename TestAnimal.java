class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Barks");
    }
}

public class TestAnimal {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound();

        Dog d = new Dog();
        d.sound();

        Animal a2 = new Dog();
        a2.sound();
    }
}
