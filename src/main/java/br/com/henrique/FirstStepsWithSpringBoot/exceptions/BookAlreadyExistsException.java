package br.com.henrique.FirstStepsWithSpringBoot.exceptions;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String msg) {
        super(msg);
    }
}
