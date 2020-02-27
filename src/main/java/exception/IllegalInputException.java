package exception;

public class IllegalInputException extends RuntimeException{
    public IllegalInputException(String userRequest){
        super(userRequest);
    }
}
