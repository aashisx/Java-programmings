// WeatherAPI.com Adapter 
// Different external API but same internal interface
public class WeatherApiComAdapter implements WeatherApiAdapter {
    private boolean available = true;
    
    @Override
    public WeatherData fetchWeather(String city) {
        System.out.println("[WeatherAPI.com] Fetching weather for: " + city);
        System.out.println("[WeatherAPI.com] Calling: api.weatherapi.com/v1/current.json");
        
        // Simulate API call - different JSON structure than OpenWeatherMap
        // {"current": {"temp_c": 26.0, "humidity": 55, "condition": {"text": "Sunny"}}}
        
        simulateNetworkDelay();
        
        // Convert API-specific format to our domain object
        return new WeatherData(
            city,
            26.0 + Math.random() * 8,
            45 + Math.random() * 35,
            "Sunny",
            12.0 + Math.random() * 15,
            "WeatherAPI.com"
        );
    }
    
    @Override
    public String getApiName() {
        return "WeatherAPI.com";
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
            Thread.sleep(400);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
