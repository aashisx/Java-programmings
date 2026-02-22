// Factory class to create Food objects
public class FoodFactory {
    
    // Factory method to create food based on type
    public Food createFood(String foodType) {
        if (foodType == null || foodType.isEmpty()) {
            return null;
        }
        
        switch (foodType.toUpperCase()) {
            case "PIZZA":
                return new Pizza();
            case "BURGER":
                return new Burger();
            case "PASTA":
                return new Pasta();
            default:
                System.out.println("Unknown food type: " + foodType);
                return null;
        }
    }
}
