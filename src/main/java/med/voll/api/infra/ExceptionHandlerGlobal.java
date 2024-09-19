package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerGlobal {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFounded() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> badRequest(MethodArgumentNotValidException exception){
        var exceptionBody = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(exceptionBody.stream().map(BodyException400::new).toList());
    }

    private record BodyException400(String message, String field){
        public BodyException400(FieldError error){
        this(error.getDefaultMessage(), error.getField());
        }
    }
}
