package br.com.henrique.LibraryAPI.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class InvalidBookDataException extends RuntimeException {
    public InvalidBookDataException(String message) {
        super(message);
    }

    public static class RestErrorMessage {
        private LocalDateTime timestamp;
        private HttpStatus status;
        private String error;
        private String message;
        private String path;

        public RestErrorMessage(LocalDateTime timestamp, HttpStatus status, String error, String message, String path) {
            this.timestamp = timestamp;
            this.status = status;
            this.error = error;
            this.message = message;
            this.path = path;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public void setStatus(HttpStatus status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

    @ControllerAdvice
    public static class RestExceptionHandler {

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
}
