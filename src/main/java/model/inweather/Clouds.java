package model.inweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Clouds {
    @JsonProperty("all")
    private int cloudPowl;
}
