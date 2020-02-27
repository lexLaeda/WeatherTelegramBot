package jason;

import bean.weather.Weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.openweather.CityNotFoundException;
import personal.BotNameToken;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherCal implements BotNameToken {
    private final static String CITYKEY = "q=";
    private final static String UNITS = "units=metric";
    private final String OPENWETHERADRESS = "http://api.openweathermap.org/data/2.5/weather?";
    private final String del = "&";




    public String getDaylyWeather(String cityName){
        Weather weather = getWeather(cityName);
        return getDaylyWeather(weather.getName(),
                weather.getTempPressure().getTemp(),
                weather.getTempPressure().getFeelsLike(),
                weather.getWeatherMainParamList().get(0).getDescription());
    }
    public Weather getWeather(String cityName)  {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Weather weather = mapper.readValue(getJasonString(cityName), Weather.class);
            return weather;
        } catch (IOException e) {
            e.printStackTrace();
            throw new CityNotFoundException(e.getMessage());
        }
    }
    private String getDaylyWeather(String cityName,String temp, String feelsLike, String sky){
        StringBuilder sb = new StringBuilder();
        sb.append(cityName);
        sb.append("\n");
        sb.append("Температура " + temp);
        sb.append("\n");
        sb.append("Ощущается как " + feelsLike);
        sb.append("\n");
        sb.append("Облачность " + sky);
        return sb.toString();
    }

    private String getJasonString(String cityName){
        String httpRequet;
        if (cityName != null && isEng(cityName)){
            httpRequet = OPENWETHERADRESS + CITYKEY + cityName +
                    del + UNITS + del + WEATHERAPIKEY;
        } else if (cityName !=null && isRus(cityName)){
            httpRequet = OPENWETHERADRESS + CITYKEY + cityName + del
                    + UNITS + del + WEATHERAPIKEY;
            System.out.println(httpRequet);
        } else {
            throw new UnsupportedOperationException();
        }
        return MyDownLoader.getContent(httpRequet);
    }
    private boolean isEng(String string){
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
    private boolean isRus(String string){
        Pattern pattern = Pattern.compile("[а-яА-Я]");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
