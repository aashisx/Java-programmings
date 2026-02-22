// OpenWeatherMap API Adapter - Version 2.0 (API Changed!)
// Demonstrates handling API changes without affecting core logic
public class OpenWeatherMapV2Adapter implements WeatherApiAdapter {
    private boolean available = true;
    
    @Override
    public WeatherData fetchWeather(String city) {
        System.out.println("[OpenWeatherMap v2.0] Fetching weather for: " + city);
        System.out.println("[OpenWeatherMap v2.0] Calling: api.openweathermap.org/data/3.0/weather");
        System.out.println("[OpenWeatherMap v2.0] Using new API structure...");
        
        // Simulate NEW API format (v2.0 - structure changed)
        // {"data": {"temp": {"value": 27.0, "unit": "C"}, "conditions": {"primary": "Clear"}}}
        
        simulateNetworkDelay();
        
        // Adapter handles the new format internally
        // Core logic still receives same WeatherData object
        return new WeatherData(
            city,
            27.0 + Math.random() * 9,
            55 + Math.random() * 25,
            "Clear Sky",
            18.0 + Math.random() * 12,
            "OpenWeatherMap v2.0"
        );
    }
    
    @Override
    public String getApiName() {
        return "OpenWeatherMap v2.0";
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
            Thread.sleep(450);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
