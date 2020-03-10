package model.inweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Snow {
    @JsonProperty("1h")
    private String oneHoour;
    @JsonProperty("3h")
    private String threeHour;
}
