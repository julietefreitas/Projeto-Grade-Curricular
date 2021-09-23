package com.rasmo.escola.exception;

import org.springframework.http.HttpStatus;

public class MateriaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus httpStatus;

	public MateriaException(final String mensagem, final HttpStatus httpStatus) {
		super(mensagem);
		this.httpStatus = httpStatus;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	
	

}
