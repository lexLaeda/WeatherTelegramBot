import java.lang.reflect.Type;

public interface WeatherService {
    <T>String getWeather (T type);
}
