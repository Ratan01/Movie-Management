package com.cg.app.exceptions;

public class DateException extends RuntimeException{
	private static final long serialVersionUID = -4442426717278872187L;
	
	public DateException() {
		super();
	}

	public DateException(String message) {
		super(message);
	}

	public DateException(Throwable cause) {
		super(cause);
	}

	public DateException(String message, Throwable cause) {
		super(message, cause);
	}

	public DateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
