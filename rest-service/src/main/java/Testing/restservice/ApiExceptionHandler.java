package Testing.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ApiException> badRequest(HttpClientErrorException ex, WebRequest req)
    {
        ApiException exceptionResponse = new ApiException(ex.getMessage(), req.getDescription(false),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), new Date());
        return new ResponseEntity<ApiException>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ApiException> internalError(HttpClientErrorException ex, WebRequest req)
    {
        ApiException exceptionResponse = new ApiException(ex.getMessage(), req.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), new Date());
        return new ResponseEntity<ApiException>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ApiException> internalError(NumberFormatException ex, WebRequest req)
    {
        ApiException exceptionResponse = new ApiException(ex.getMessage(), req.getDescription(false),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), new Date());
        return new ResponseEntity<ApiException>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}