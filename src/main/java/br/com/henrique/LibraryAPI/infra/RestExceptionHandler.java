package br.com.henrique.LibraryAPI.infra;

import br.com.henrique.LibraryAPI.exceptions.BookAlreadyExistsException;
import br.com.henrique.LibraryAPI.exceptions.IdNotFoundException;
import br.com.henrique.LibraryAPI.exceptions.InvalidBookDataException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<RestErrorMessage> idNotFoundHandler(IdNotFoundException exception, HttpServletRequest request) {
        RestErrorMessage threatResponse = new RestErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND, "Book not found.", "Id not found.", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<RestErrorMessage> bookAlreadyExistsHandler(BookAlreadyExistsException exception, HttpServletRequest request) {
        RestErrorMessage threatResponse = new RestErrorMessage(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Book already exists.", "ISBN is already registered in a book.", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

    @ExceptionHandler(InvalidBookDataException.class)
    public ResponseEntity<RestErrorMessage> invalidBookDataHandler(InvalidBookDataException exception, HttpServletRequest request) {
        RestErrorMessage threatResponse = new RestErrorMessage(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Invalid data.", "The data provided for the book is invalid.", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
}
