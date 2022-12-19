package com.api.deliverymanager.exceptions;

public class ObjectInConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectInConflictException(String message) {
        super(message);
    }

}
