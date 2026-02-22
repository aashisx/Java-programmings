// Concrete class for Dog
public class Dog implements Animal {
    
    @Override
    public void sound() {
        System.out.println("Dog says: Woof! Woof!");
    }
    
    @Override
    public String getAnimalType() {
        return "DOG";
    }
}
