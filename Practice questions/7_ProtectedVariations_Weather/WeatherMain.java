import java.util.Scanner;

// Main class demonstrating Protected Variations pattern
public class WeatherMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=============================================");
        System.out.println("   WEATHER DATA SERVICE");
        System.out.println("   (Protected Variations Pattern)");
        System.out.println("=============================================\n");
        
        // Create service
        WeatherService service = new WeatherService();
        
        // Create adapters (protection layer against API changes)
        OpenWeatherMapAdapter owmV1 = new OpenWeatherMapAdapter();
        OpenWeatherMapV2Adapter owmV2 = new OpenWeatherMapV2Adapter();
        WeatherApiComAdapter weatherApi = new WeatherApiComAdapter();
        
        // Register adapters
        service.addAdapter(owmV1);
        service.addAdapter(owmV2);
        service.addAdapter(weatherApi);
        
        while (true) {
            System.out.println("\n--- Weather Service Menu ---");
            System.out.println("Current API: " + service.getCurrentAdapter().getApiName());
            System.out.println();
            System.out.println("1. Get Weather Report");
            System.out.println("2. Get Weather Advice");
            System.out.println("3. Switch to OpenWeatherMap v1.0");
            System.out.println("4. Switch to OpenWeatherMap v2.0 (API Changed)");
            System.out.println("5. Switch to WeatherAPI.com");
            System.out.println("6. Simulate API Failure & Fallback");
            System.out.println("7. Demonstrate Protected Variations");
            System.out.println("8. EXIT");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    System.out.print("Enter city name: ");
                    String city1 = scanner.nextLine().trim();
                    service.displayWeatherReport(city1);
                    break;
                    
                case "2":
                    System.out.print("Enter city name: ");
                    String city2 = scanner.nextLine().trim();
                    System.out.println(service.getWeatherAdvice(city2));
                    break;
                    
                case "3":
                    service.setCurrentAdapter(owmV1);
                    break;
                    
                case "4":
                    service.setCurrentAdapter(owmV2);
                    break;
                    
                case "5":
                    service.setCurrentAdapter(weatherApi);
                    break;
                    
                case "6":
                    demonstrateFailover(service, owmV1, weatherApi);
                    break;
                    
                case "7":
                    demonstrateProtectedVariations(owmV1, owmV2, weatherApi);
                    break;
                    
                case "8":
                    System.out.println("Thank you for using Weather Service!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void demonstrateFailover(WeatherService service, 
                                             OpenWeatherMapAdapter primary,
                                             WeatherApiComAdapter fallback) {
        System.out.println("\n============================================");
        System.out.println("DEMONSTRATING API FAILOVER");
        System.out.println("============================================");
        
        // Set primary adapter
        service.setCurrentAdapter(primary);
        
        System.out.println("\n--- Normal Operation ---");
        service.displayWeatherReport("Kathmandu");
        
        System.out.println("\n--- Simulating Primary API Failure ---");
        primary.setAvailable(false);
        System.out.println("[SIMULATION] OpenWeatherMap API is DOWN!");
        
        service.displayWeatherReport("Kathmandu");
        
        // Restore
        primary.setAvailable(true);
        System.out.println("\n[SIMULATION] OpenWeatherMap API restored");
        
        System.out.println("============================================");
    }
    
    private static void demonstrateProtectedVariations(
            OpenWeatherMapAdapter v1,
            OpenWeatherMapV2Adapter v2,
            WeatherApiComAdapter other) {
        
        System.out.println("\n============================================");
        System.out.println("DEMONSTRATING PROTECTED VARIATIONS");
        System.out.println("============================================");
        
        System.out.println("\nScenario: API provider changed their response format");
        System.out.println("from v1.0 to v2.0 (breaking change)");
        System.out.println("\nWithout Protected Variations:");
        System.out.println("  - Core logic would break");
        System.out.println("  - Need to modify business code");
        System.out.println("\nWith Protected Variations:");
        System.out.println("  - Only update/create adapter");
        System.out.println("  - Core logic unchanged!");
        
        WeatherService service = new WeatherService();
        
        System.out.println("\n--- Using v1.0 API ---");
        service.addAdapter(v1);
        service.displayWeatherReport("London");
        
        System.out.println("\n--- API Provider Updated to v2.0 ---");
        System.out.println("(JSON structure completely different)");
        service.addAdapter(v2);
        service.setCurrentAdapter(v2);
        service.displayWeatherReport("London");
        
        System.out.println("\n--- Switching to Different Provider ---");
        service.addAdapter(other);
        service.setCurrentAdapter(other);
        service.displayWeatherReport("London");
        
        System.out.println("\n============================================");
        System.out.println("KEY POINTS:");
        System.out.println("- WeatherService code NEVER changed");
        System.out.println("- WeatherData format remains consistent");
        System.out.println("- Adapters absorb all API variations");
        System.out.println("- Easy to add new providers");
        System.out.println("============================================");
    }
}
