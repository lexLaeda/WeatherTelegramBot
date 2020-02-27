package exception.openweather;

import exception.IllegalInputException;

public class CityNotFoundException extends IllegalInputException {
    public CityNotFoundException(String userRequest) {
        super(userRequest);
    }
}
