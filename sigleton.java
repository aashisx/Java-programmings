public class sigleton {
    private static sigleton instance;

    private sigleton() {
        // Private constructor to prevent instantiation
    }

    public static sigleton getInstance() {
        if (instance == null) {
            instance = new sigleton();
        }
        return instance;
    }

    public void someMethod() {
        System.out.println("This is a method in the singleton class.");
    }
}
