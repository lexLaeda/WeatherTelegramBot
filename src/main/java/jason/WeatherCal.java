package jason;

import bean.weather.Weather;

import bean.weather.inweather.TempPressure;
import bean.weather.inweather.Wind;
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
    private final String OPENWETHERADRESS = "http://api.openweathermap.org/data/2.5/weather?";
    private final String del = "&";
    private final static String DIG = "℃";
    private final static String PERCENT = "%";

    public String getDaylyWeather(String cityName){
        Weather weather = getWeather(cityName);

        return getDaylyWeather(
                weather.getTempPressure().getTemp(),
                weather.getTempPressure().getFeelsLike(),
                weather.getTempPressure().getHumidity(),
                weather.getWind().getSpeed(),
                weather.getWind().getDir());
    }
    public Weather getWeather(String cityName)  {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(getJasonString(cityName), Weather.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CityNotFoundException(e.getMessage());
        }
    }
    private String getDaylyWeather(String temp, String feelsLike, String humidity,double windSpeed, double windDir){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.ENGLISH,"Температура в тени %s %s",temp,DIG));
        sb.append("\n");
        sb.append(String.format(Locale.ENGLISH,"Ощущается как %s %s",feelsLike,DIG));
        sb.append("\n");
        sb.append(String.format(Locale.ENGLISH,"Влажность %s %s",humidity,PERCENT));
        sb.append("\n");
        sb.append(String.format(Locale.ENGLISH,"Ветер %s скорость %s м/с",getWindDirection(windDir),windSpeed));
        sb.append("\n");
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
    private String getWindDirection(double dir) {
        if (0 <= dir && dir <= 22.5 || 337.5 <= dir) {
            return "Северный";
        } else if (22.5 < dir && dir <= 67.5) {
            return "Северо-восточный";
        } else if (67.5 < dir && dir <= 112.5) {
            return "Восточный";
        } else if (112.5 < dir && dir <= 157.5) {
            return "Юго-восточный";
        } else if (157.5 < dir && dir <= 202.5) {
            return "Южный";
        } else if (202.5 < dir && dir <= 247.5) {
            return "Юго-западный";
        } else if (247.5 < dir && dir <= 292.5) {
            return "Западный";
        } else {
            return "Северо-западный";
        }
    }


}
