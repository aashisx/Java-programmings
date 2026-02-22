class Vehicle {
    void start() {
        System.out.println("Vehicle is starting...");
    }
}
class Car extends Vehicle {
    void playMusic() {
        System.out.println("Playing music in the car...");
    }
}
public class TestVehicle {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        v1.start();

        Car c1 = (Car) v1;
        c1.playMusic();

        Vehicle v2 = new Vehicle();
        try {
            Car c2 = (Car) v2;
            c2.playMusic();
        } catch (ClassCastException e) {
            System.out.println("Downcasting plain Vehicle to Car failed: " + e);
        }
    }
}
