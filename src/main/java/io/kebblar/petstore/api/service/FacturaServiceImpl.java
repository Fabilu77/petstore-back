package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.exception.BusinessException;
import io.kebblar.petstore.api.exception.FacturaIncorrectaException;
import io.kebblar.petstore.api.mapper.FacturaMapper;
import io.kebblar.petstore.api.model.Factura;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    private FacturaMapper facturaMapper;

    public FacturaServiceImpl(FacturaMapper facturaMapper){
        this.facturaMapper=facturaMapper;
    }

    @Override
    public int insert(Factura factura) throws BusinessException {
        try {
            return this.facturaMapper.insert(factura);
        } catch (SQLException t) {
            throw new FacturaIncorrectaException(t.getMessage());
        }
    }

    @Override
    public List<Factura> getAll() throws BusinessException {
        try {
            return this.facturaMapper.getAll();
        } catch (SQLException t) {
            throw new BusinessException("Ha ocurrido un error" + t.getMessage());
        }
    }
}
