package org.example;

public class StringCalculatorInvalidInputException extends IllegalArgumentException{

    public StringCalculatorInvalidInputException(String message){
        super(message);
    }
}
