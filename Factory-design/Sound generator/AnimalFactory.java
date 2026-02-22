// Factory class to create Animal objects
public class AnimalFactory {
    
    // Factory method to create animals based on type
    public Animal createAnimal(String animalType) {
        if (animalType == null || animalType.isEmpty()) {
            return null;
        }
        
        switch (animalType.toUpperCase()) {
            case "DOG":
                return new Dog();
            case "CAT":
                return new Cat();
            case "COW":
                return new Cow();
            default:
                System.out.println("Unknown animal type: " + animalType);
                return null;
        }
    }
}
