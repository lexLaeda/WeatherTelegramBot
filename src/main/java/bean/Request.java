package bean;

import exception.comandexception.NotACommandException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import myenum.Command;


@Getter
@AllArgsConstructor
public class Request {
    Command command;
    String args;
}
