package com.sravanth.restdemo.exception;

public class NotesNotFoundException extends RuntimeException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotesNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotesNotFoundException(String message) {
		super(message);
	}

	public NotesNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
