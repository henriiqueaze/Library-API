package br.com.henrique.LibraryAPI.exceptions;

public class InvalidBookDataException extends RuntimeException {
    public InvalidBookDataException(String message) {
        super(message);
    }
}
