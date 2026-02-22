// Weather API Adapter Interface - Protection against API changes
// Core logic depends on this stable interface
public interface WeatherApiAdapter {
    WeatherData fetchWeather(String city);
    String getApiName();
    boolean isAvailable();
}
