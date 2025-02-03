package org.numerals.RomanNumerals;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(org.springframework.web.bind.MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, Object>> handleParamsMissing(Exception e) {
        return ResponseEntity.badRequest()
            .body(Map.of("error", "[Missing Parameter] " + e.getMessage()));
    }

    @ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidParamType(Exception e) {
        return ResponseEntity.badRequest()
            .body(Map.of("error", "[Invalid Parameter Type] " + e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(Exception e) {
        return ResponseEntity.badRequest()
            .body(Map.of("error", "[Invalid Parameter] " + e.getMessage()));
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<Map<String, Object>> handleUnsupportedOperation(Exception e) {
        return ResponseEntity.badRequest()
            .body(Map.of("error", "[Unsupported Operation] " + e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleUnknownError(Exception e) {
        return ResponseEntity.internalServerError()
            .body(Map.of("error", "[Unknown Error] " + e.getMessage()));
    }
}
