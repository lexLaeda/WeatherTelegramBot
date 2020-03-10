package model.inweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @JsonProperty("lon")
    private float longitude;
    @JsonProperty("lat")
    private float latitude;
}
