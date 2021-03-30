package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.exceptions.ProductoInexistenteException;
import io.kebblar.petstore.api.mapper.FacturaMapper;
import io.kebblar.petstore.api.model.Factura;

@Service
public class FacturaServiceImpl implements FacturaService{
	
	private FacturaMapper facturaMapper;
	
	public FacturaServiceImpl(FacturaMapper facturaMapper) {
		this.facturaMapper = facturaMapper;
	}
	
	@Override
	public int insert(Factura factura) throws BusinessException {
		try {
			return this.facturaMapper.insert(factura);
		} catch (SQLException e) {
			throw new ProductoInexistenteException("Lo lamentamos, pero ha ocurrido un error en la BD. Consulte con su administrador y proporcione el siguiente código: "+e.getErrorCode());
		}
	}

	@Override
	public List<Factura> getAll() throws BusinessException {
		try {
			/*
			Factura f1 = new Factura(1, new Date(), "AESG771022XYZ", 123, 234.5, 15);
			Factura f2 = new Factura(2, new Date(), "BCD7710222XYZ", 123, 234.5, 14);
			List<Factura> resultado = new ArrayList<>();
			resultado.add(f1);
			resultado.add(f2);
			return resultado;*/
			return this.facturaMapper.getAll();
		} catch (Exception e) {
			//throw new BusinessException("Texto adecaudo..."+e.getErrorCode());
			throw new BusinessException("Texto adecaudo..."+e.getMessage());
		}
	}

}
