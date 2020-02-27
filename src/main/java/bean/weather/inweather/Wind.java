package bean.weather.inweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Wind {
    @JsonProperty("speed")
    private double speed;
    @JsonProperty("deg")
    private double dir;
}
