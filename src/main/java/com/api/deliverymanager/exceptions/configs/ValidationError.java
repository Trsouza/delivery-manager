package com.api.deliverymanager.exceptions.configs;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final long serialVersionUID = 1L;

    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String error, String message, String path, Long timestamp ) {
        super(status, error, message, path, timestamp);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
