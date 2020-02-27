package bean.weather.inweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TempPressure {
    @JsonProperty("temp")
    private String temp;
    @JsonProperty("sea_level")
    private String seaLevel;
    @JsonProperty("grnd_level")
    private String grndLevel;
    @JsonProperty("feels_like")
    private String feelsLike;
    @JsonProperty("temp_min")
    private String minTemp;
    @JsonProperty("temp_max")
    private String maxTemp;
    @JsonProperty("pressure")
    private String pressure;
    @JsonProperty("humidity")
    private String humidity;
}
