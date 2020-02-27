package exception.comandexception;

import exception.IllegalInputException;

public class NotACommandException extends IllegalInputException {
    public NotACommandException(String userRequest) {
        super(userRequest + " command should starts with \"/\"");
    }
}
