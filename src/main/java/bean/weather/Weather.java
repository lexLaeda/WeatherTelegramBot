package bean.weather;

import bean.weather.inweather.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
@Getter
@Setter
@ToString
public class Weather {
    @JsonProperty("coord")
    private Location location;
    @JsonProperty("weather")
    private ArrayList<WeatherMainParam> weatherMainParamList;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private TempPressure tempPressure;
    @JsonProperty("visibility")
    private int visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("rain")
    private Rain rain;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("dt")
    private Date date;
    @JsonProperty("sys")
    private Aditional aditional;
    @JsonProperty("timezone")
    private int timezone;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private int zipCod;

}
