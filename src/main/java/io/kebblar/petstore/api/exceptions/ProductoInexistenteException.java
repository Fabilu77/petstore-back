package io.kebblar.petstore.api.exceptions;

public class ProductoInexistenteException extends BusinessException{
	
	public ProductoInexistenteException(String msg) {
		super(msg);
	}

}
