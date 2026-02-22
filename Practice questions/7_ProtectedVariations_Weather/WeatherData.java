// Weather Data - Domain object independent of external APIs
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final String condition;
    private final double windSpeed;
    private final String source;
    
    public WeatherData(String city, double temperature, double humidity, 
                       String condition, double windSpeed, String source) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
        this.windSpeed = windSpeed;
        this.source = source;
    }
    
    public String getCity() {
        return city;
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    public double getHumidity() {
        return humidity;
    }
    
    public String getCondition() {
        return condition;
    }
    
    public double getWindSpeed() {
        return windSpeed;
    }
    
    public String getSource() {
        return source;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Weather for %s:\n" +
            "  Temperature: %.1f°C\n" +
            "  Humidity: %.1f%%\n" +
            "  Condition: %s\n" +
            "  Wind Speed: %.1f km/h\n" +
            "  Data Source: %s",
            city, temperature, humidity, condition, windSpeed, source
        );
    }
}
