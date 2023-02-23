package com.api.deliverymanager.exceptions.configs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.RollbackException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.deliverymanager.exceptions.ObjectInConflictException;
import com.api.deliverymanager.exceptions.GenericException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
	
	private static final String DATA_INTEGRITY_VIOLATION = "Data integrity violation";
	
    private static final Map<String, String> CONSTRAINTS_MAP = Map.of(
            "idx_uniq_email", "Email already registered",
            "fk_email_un", "Email already registered",
            "name_user_fk_email_un", "An email can only be associated with one user");

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<StandardError> genericException(GenericException e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), "There was a problem requesting the operation", e.getMessage(), request.getRequestURI(), System.currentTimeMillis());
        log.error("BAD REQUEST: {} => {}", err.getError(), err.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), "Not found", e.getMessage(), request.getRequestURI(),System.currentTimeMillis());
        log.error("NOT FOUND: {} => {}", err.getError(), err.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<StandardError> contraintViolationException(TransactionSystemException e, HttpServletRequest request) {
    	var rootMsg = Objects.requireNonNull(e.getRootCause()).getMessage();
    	var message="";
        if (rootMsg != null) {
            var lowerCaseMsg = rootMsg.toLowerCase();
            for (Map.Entry<String, String> entry : CONSTRAINTS_MAP.entrySet()) {
                if (lowerCaseMsg.contains(entry.getKey())) {
                    message = entry.getValue();
                }
            }
        }
        
    	StandardError err = new StandardError(
                HttpStatus.BAD_REQUEST.value(),
                DATA_INTEGRITY_VIOLATION,
                "Unable to perform the transaction: "+ message,
                request.getContextPath(),
                System.currentTimeMillis()
        );
        
        
        log.error("BAD REQUEST: {} => {}", err.getError(), err.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<StandardError> dataIntegrityException(DataIntegrityViolationException e, HttpServletRequest request) {
//    	var rootMsg = Objects.requireNonNull(e.getRootCause()).getMessage();
//    	var message="";
//        if (rootMsg != null) {
//            var lowerCaseMsg = rootMsg.toLowerCase();
//            for (Map.Entry<String, String> entry : CONSTRAINTS_MAP.entrySet()) {
//                if (lowerCaseMsg.contains(entry.getKey())) {
//                    message = entry.getValue();
//                }
//            }
//        }
//    	
//    	StandardError err = new StandardError(
//                HttpStatus.BAD_REQUEST.value(),
//                DATA_INTEGRITY_VIOLATION,
//                "Unable to perform the transaction: "+ message,
//                request.getContextPath(),
//                System.currentTimeMillis()
//        );
//        log.error("BAD REQUEST: {} => {}", err.getError(), err.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//    }

    @ExceptionHandler(RollbackException.class)
    public ResponseEntity<StandardError> handleNotValidException(RollbackException ex, HttpServletRequest request){
        StandardError err = new StandardError(
                HttpStatus.NOT_ACCEPTABLE.value(),
                DATA_INTEGRITY_VIOLATION,
                "Unable to perform the transaction",
                request.getContextPath(),
                System.currentTimeMillis()
        );
        log.error("NOT ACCEPTABLE: {} => {}", err.getError(), err.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(err);

    }

    @ExceptionHandler(ObjectInConflictException.class)
    public ResponseEntity<StandardError> objectInConflictException(ObjectInConflictException e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.CONFLICT.value(), "There was a problem requesting the operation", e.getMessage(), request.getRequestURI(),System.currentTimeMillis());
        log.error("CONFLICT: {} => {}", err.getError(), err.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation error", e.getMessage(), request.getRequestURI(), System.currentTimeMillis());

        List<ObjectError> allErrors = e.getAllErrors();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Set<String> msgs = new HashSet<>();
        if (!allErrors.isEmpty()) {
            allErrors.forEach(objectError -> msgs.add(objectError.getDefaultMessage()));
        }
        if (!fieldErrors.isEmpty()) {
            fieldErrors.forEach(fieldError -> msgs.add(fieldError.getDefaultMessage()));
        }
        msgs.forEach(msg -> err.addError("", msg));
        log.error("BAD REQUEST: {} => {}", err.getError(), err.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }


}
