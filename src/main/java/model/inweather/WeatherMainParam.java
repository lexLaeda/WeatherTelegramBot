package model.inweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherMainParam {
    @JsonProperty("id")
    private long id;
    @JsonProperty("main")
    private String main;
    @JsonProperty("description")
    private String description;
    @JsonProperty("icon")
    private String icon;
}
