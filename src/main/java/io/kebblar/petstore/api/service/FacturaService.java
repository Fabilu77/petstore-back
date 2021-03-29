package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.exception.BusinessException;
import io.kebblar.petstore.api.model.Factura;

import java.util.List;

public interface FacturaService {

    int insert(Factura factura) throws BusinessException;

    List<Factura> getAll() throws BusinessException;
}
