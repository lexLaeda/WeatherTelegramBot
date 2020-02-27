package exception.comandexception;

import exception.IllegalInputException;

public class ComandNotFoundException extends IllegalInputException {
    public ComandNotFoundException(String userRequest) {
        super(String.format("%s я не знаю такой команды \n " +
                "для вызова списка команд введите /list",userRequest));
    }
}
