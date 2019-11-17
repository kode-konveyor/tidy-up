package com.kodekonveyor.webapp;

public class ValidationException extends RuntimeException {

	public ValidationException(final String nullOwnerId) {
		super(nullOwnerId);
	}

	private static final long serialVersionUID = 8099048825122345809L;

}
