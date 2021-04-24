package com.comerzzia.bookerzzia.backoffice.services.comunidades;


public class ComunidadNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2619930313967766048L;

	public ComunidadNotFoundException() {
	}

	public ComunidadNotFoundException(String message) {
		super(message);
	}

	public ComunidadNotFoundException(Throwable cause) {
		super(cause);
	}

	public ComunidadNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComunidadNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
