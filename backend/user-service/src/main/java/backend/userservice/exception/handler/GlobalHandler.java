package backend.userservice.exception.handler;

import backend.userservice.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.function.BiFunction;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    ProblemDetail handle(EntityNotFoundException e) {
        return withDetails.apply(HttpStatus.NOT_FOUND, e);
    }

    private final BiFunction<HttpStatus, Exception, ProblemDetail>
            withDetails = (s, e) -> ProblemDetail
            .forStatusAndDetail(s, e.getMessage());

}
