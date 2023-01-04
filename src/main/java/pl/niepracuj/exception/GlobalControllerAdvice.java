package pl.niepracuj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.niepracuj.exception.exceptions.EntityNotFoundException;
import pl.niepracuj.exception.exceptions.ResourceNotFoundException;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(Exception e) {
        return new ResponseEntity<>(getBody(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(Exception e) {
        return new ResponseEntity<>(getBody(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);

    }
    private Map<Object, Object> getBody(HttpStatus status, Object message) {
       Map<Object, Object> body = new LinkedHashMap<>();
       body.put("time", Instant.now());
       body.put("code", status.value());
       body.put("error", status.getReasonPhrase());
       body.put("message", message);
       return body;
    }
}
