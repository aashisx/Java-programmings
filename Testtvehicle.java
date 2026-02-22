abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}

class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike starts with kick");
    }
}

public class Testtvehicle {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        v1.start();

        Vehicle v2 = new Bike();
        v2.start();
    }
}

