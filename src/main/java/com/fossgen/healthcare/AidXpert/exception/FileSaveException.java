package com.fossgen.healthcare.AidXpert.exception;

public class FileSaveException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileSaveException(String message) {
		super(message);
	}

	public FileSaveException(String message, Throwable cause) {
		super(message, cause);
	}
}
