// OpenWeatherMap API Adapter - Version 1.0
// Adapts external API to internal interface
public class OpenWeatherMapAdapter implements WeatherApiAdapter {
    private boolean available = true;
    
    // Simulated API response format (JSON-like structure)
    // Real implementation would use HTTP client and JSON parsing
    
    @Override
    public WeatherData fetchWeather(String city) {
        System.out.println("[OpenWeatherMap v1.0] Fetching weather for: " + city);
        System.out.println("[OpenWeatherMap v1.0] Calling: api.openweathermap.org/data/2.5/weather");
        
        // Simulate API call and response parsing
        // In real implementation, this would handle JSON like:
        // {"main": {"temp": 25.5, "humidity": 60}, "weather": [{"description": "sunny"}]}
        
        simulateNetworkDelay();
        
        // Convert API-specific format to our domain object
        return new WeatherData(
            city,
            25.5 + Math.random() * 10,  // Temperature
            50 + Math.random() * 30,     // Humidity
            "Partly Cloudy",
            15.0 + Math.random() * 10,   // Wind
            "OpenWeatherMap v1.0"
        );
    }
    
    @Override
    public String getApiName() {
        return "OpenWeatherMap";
    }
    
    @Override
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    private void simulateNetworkDelay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
