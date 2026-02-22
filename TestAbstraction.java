abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with a button");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with a kick");
    }
}

public class TestAbstraction {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        v1.start();

        Vehicle v2 = new Bike();
        v2.start();
    }
}

