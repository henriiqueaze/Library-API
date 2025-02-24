package br.com.henrique.LibraryAPI.exceptions;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String msg) {
        super(msg);
    }
}
