package exception.empty;

import exception.IllegalInputException;

public class EmptyRequestException extends IllegalInputException{
    public EmptyRequestException(String request){
        super(request + "Запрос не может быть пустым");
    }
}
