package br.com.henrique.FirstStepsWithSpringBoot.exceptions;

public class InvalidBookDataException extends RuntimeException {
    public InvalidBookDataException(String message) {
        super(message);
    }
}
