package com.cg.app.exceptions;

public class UserException extends Exception{
	
	private static final long serialVersionUID= -132434556778886643L;
	
	public UserException() {
		super();
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
