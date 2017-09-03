package com.waltercrdz.poker.domain.exception;

public class EmptyDeckException extends RuntimeException {

	private static final long serialVersionUID = -3526732767149380887L;

	public EmptyDeckException() {
		super();
	}

	public EmptyDeckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmptyDeckException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyDeckException(String message) {
		super(message);
	}

	public EmptyDeckException(Throwable cause) {
		super(cause);
	}
	
}
