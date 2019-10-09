package com.nursery_school.manager.tools;

public class AuthorizationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorizationException() {
	}

	public AuthorizationException(String message) {
		super(message);
	}

	public AuthorizationException(String message, Throwable cause) {
		super(message, cause);
	}
}