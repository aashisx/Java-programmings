// Concrete class for Cow
public class Cow implements Animal {
    
    @Override
    public void sound() {
        System.out.println("Cow says: Moo! Moo!");
    }
    
    @Override
    public String getAnimalType() {
        return "COW";
    }
}
