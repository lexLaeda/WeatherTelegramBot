package jason;

import model.Weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.openweather.CityNotFoundException;
import personal.BotNameToken;

import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherCal implements BotNameToken {
    private final static String CITYKEY = "q=";
    private final static String UNITS = "units=metric";
    private final static String OPENWETHERADRESS = "http://api.openweathermap.org/data/2.5/weather?";
    private final static String del = "&";

    public static Weather getWeather(String cityName)  {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(getJasonString(cityName), Weather.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CityNotFoundException(e.getMessage());
        }
    }


    private static String getJasonString(String cityName){
        String httpRequet;
        if (cityName != null && isEng(cityName)){
            httpRequet = OPENWETHERADRESS + CITYKEY + cityName +
                    del + UNITS + del + WEATHERAPIKEY;
        } else if (cityName !=null && isRus(cityName)){
            httpRequet = OPENWETHERADRESS + CITYKEY + cityName + del
                    + UNITS + del + WEATHERAPIKEY;
        } else {
            throw new UnsupportedOperationException();
        }
        return MyDownLoader.getContent(httpRequet);
    }
    private static boolean isEng(String string){
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
    private static  boolean isRus(String string){
        Pattern pattern = Pattern.compile("[а-яА-Я]");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }



}
