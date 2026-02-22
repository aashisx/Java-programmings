import java.util.ArrayList;
import java.util.List;

// Weather Service - Core business logic
// Protected from external API changes via adapter interface
public class WeatherService {
    private final List<WeatherApiAdapter> adapters;
    private WeatherApiAdapter currentAdapter;
    
    public WeatherService() {
        this.adapters = new ArrayList<>();
    }
    
    public void addAdapter(WeatherApiAdapter adapter) {
        adapters.add(adapter);
        if (currentAdapter == null) {
            currentAdapter = adapter;
        }
        System.out.println("[SERVICE] Added adapter: " + adapter.getApiName());
    }
    
    public void setCurrentAdapter(WeatherApiAdapter adapter) {
        this.currentAdapter = adapter;
        System.out.println("[SERVICE] Switched to: " + adapter.getApiName());
    }
    
    // Core logic - completely independent of which API is used
    public WeatherData getWeather(String city) {
        if (currentAdapter == null) {
            throw new RuntimeException("No weather API adapter configured");
        }
        
        // Try current adapter first
        if (currentAdapter.isAvailable()) {
            System.out.println("\n[SERVICE] Using " + currentAdapter.getApiName());
            return currentAdapter.fetchWeather(city);
        }
        
        // Fallback to other available adapters
        for (WeatherApiAdapter adapter : adapters) {
            if (adapter.isAvailable() && adapter != currentAdapter) {
                System.out.println("\n[SERVICE] Primary unavailable, falling back to " + adapter.getApiName());
                return adapter.fetchWeather(city);
            }
        }
        
        throw new RuntimeException("No weather API available");
    }
    
    // Core logic remains unchanged regardless of API
    public void displayWeatherReport(String city) {
        System.out.println("\n========== WEATHER REPORT ==========");
        WeatherData data = getWeather(city);
        System.out.println();
        System.out.println(data);
        System.out.println("=====================================");
    }
    
    // Business logic that uses weather data
    public String getWeatherAdvice(String city) {
        WeatherData data = getWeather(city);
        
        StringBuilder advice = new StringBuilder();
        advice.append("\n--- Weather Advice for ").append(city).append(" ---\n");
        
        if (data.getTemperature() > 35) {
            advice.append("- Very hot! Stay hydrated and avoid direct sunlight.\n");
        } else if (data.getTemperature() > 25) {
            advice.append("- Warm weather. Light clothing recommended.\n");
        } else if (data.getTemperature() < 15) {
            advice.append("- Cool weather. Bring a jacket.\n");
        }
        
        if (data.getHumidity() > 70) {
            advice.append("- High humidity. May feel warmer than actual temperature.\n");
        }
        
        if (data.getWindSpeed() > 20) {
            advice.append("- Windy conditions. Secure loose items.\n");
        }
        
        return advice.toString();
    }
    
    public WeatherApiAdapter getCurrentAdapter() {
        return currentAdapter;
    }
    
    public List<WeatherApiAdapter> getAdapters() {
        return adapters;
    }
}
