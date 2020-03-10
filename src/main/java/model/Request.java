package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import myenum.Command;


@Getter
@AllArgsConstructor
public class Request {
    Command command;
    String args;
}
