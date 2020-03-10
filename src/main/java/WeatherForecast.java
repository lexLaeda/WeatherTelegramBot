import model.Weather;

import java.util.Locale;

public class WeatherForecast {
    private final String del = "&";
    private final static String DIG = "℃";
    private final static String PERCENT = "%";
    public static String getWeatherDescription(Weather weather){
        return getDaylyWeather(
                weather.getTempPressure().getTemp(),
                weather.getTempPressure().getFeelsLike(),
                weather.getTempPressure().getHumidity(),
                weather.getWind().getSpeed(),
                weather.getWind().getDir());
    }
    private static String getWindDirection(double dir) {
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
    private static String getDaylyWeather(String temp, String feelsLike, String humidity,double windSpeed, double windDir){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.ENGLISH,"Температура в тени %s %s\n",temp,DIG));
        sb.append(String.format(Locale.ENGLISH,"Ощущается как %s %s\n",feelsLike,DIG));
        sb.append(String.format(Locale.ENGLISH,"Влажность %s %s\n",humidity,PERCENT));
        sb.append(String.format(Locale.ENGLISH,"Ветер %s скорость %s м/с\n",getWindDirection(windDir),windSpeed));
        return sb.toString();
    }
}
