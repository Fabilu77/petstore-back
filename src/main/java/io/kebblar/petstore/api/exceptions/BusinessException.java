package io.kebblar.petstore.api.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception{

	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public HttpStatus getHttpError() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDescExcepcion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCveExcepcion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getIdentificador() {
		// TODO Auto-generated method stub
		return null;
	}

}
