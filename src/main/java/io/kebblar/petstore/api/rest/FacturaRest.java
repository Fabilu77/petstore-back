package io.kebblar.petstore.api.rest;

import io.kebblar.petstore.api.exception.BusinessException;
import io.kebblar.petstore.api.model.Factura;
import io.kebblar.petstore.api.service.FacturaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class FacturaRest {

    private FacturaService facturaService;

    public FacturaRest(FacturaService facturaService){
        this.facturaService=facturaService;
    }

    @GetMapping(path = "/getAll.json", produces = "application/json; charset=utf-8")
    public List<Factura> getAll() throws BusinessException {
        return this.facturaService.getAll();
    }

    @PostMapping(path = "/insert.json", produces = "application/json; charset=utf-8")
    public int insert(Factura factura) throws BusinessException {
        return this.facturaService.insert(factura);
    }
}
