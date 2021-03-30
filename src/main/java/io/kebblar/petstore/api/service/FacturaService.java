package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.model.Factura;

public interface FacturaService {
	
	int insert(Factura factura) throws BusinessException;
	/**
	 * Regresa la totalidad de facturas almacenadas en la BD
	 * @return Lista de objetos de tipo factura
	 * @throws BusinessException Se dispara en caso de que no haya fondos en la cuenta de retiro
	 */
	List<Factura> getAll() throws BusinessException;
	//qué hace más no como lo hace
}
