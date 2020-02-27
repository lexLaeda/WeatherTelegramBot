package jason;

import bean.weather.Weather;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class WeatherCalTest {
    private WeatherCal weatherCal;
    private String cityEngLondon = "London";
    private String cityEngMoskov = "Moscow";
    private String cityEngSaintPetersburg = "Saint Petersburg";
    private String cityEngNarva = "Narva";
    private String cityRusLondon = "Лондон";
    private String cityRusMoskov = "Москва";
    private String cityRusSaintPetersburg = "Санкт-Петербург";
    private String cityRusNarva= "Нарва";
    @Before
    public void setUp() throws Exception {
        weatherCal = new WeatherCal();
    }

    @Test
    public void testGetWeather() {
        Weather weatherLonEng = weatherCal.getWeather(cityEngLondon);
        Weather weatherMosEng = weatherCal.getWeather(cityEngMoskov);
        Weather weatherSPetEng = weatherCal.getWeather(cityEngSaintPetersburg);
        Weather weatherNarvaEng = weatherCal.getWeather(cityEngNarva);

        assertEquals(cityEngLondon,weatherLonEng.getName());
        assertNotNull(weatherLonEng.getWeatherMainParamList());
        assertNotNull(weatherLonEng.getLocation());
        assertNotNull(weatherLonEng.getAditional());
        assertEquals(cityEngMoskov,weatherMosEng.getName());
        assertEquals(cityEngSaintPetersburg,weatherSPetEng.getName());
        assertEquals(cityEngNarva,weatherNarvaEng.getName());

        Weather weatherLonRus = weatherCal.getWeather(cityRusLondon);
        Weather weatherMosRus = weatherCal.getWeather(cityRusMoskov);
        Weather weatherSPetRus = weatherCal.getWeather(cityRusSaintPetersburg);
        Weather weatherNarvaRus = weatherCal.getWeather(cityRusNarva);

        assertEquals(cityEngLondon,weatherLonRus.getName());
        assertEquals(cityEngMoskov,weatherMosRus.getName());
        assertNotNull(weatherMosRus.getWeatherMainParamList());
        assertNotNull(weatherMosRus.getLocation());
        assertNotNull(weatherMosRus.getAditional());
        assertEquals(cityEngSaintPetersburg,weatherSPetRus.getName());
        assertEquals(cityEngNarva,weatherNarvaRus.getName());
    }
    @Test
    public void testGetDailyWeather(){
        String dailyWeather = weatherCal.getDaylyWeather(cityEngLondon);
        System.out.println(dailyWeather);
    }
}