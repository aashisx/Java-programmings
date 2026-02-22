// Concrete class for Cat
public class Cat implements Animal {
    
    @Override
    public void sound() {
        System.out.println("Cat says: Meow! Meow!");
    }
    
    @Override
    public String getAnimalType() {
        return "CAT";
    }
}
