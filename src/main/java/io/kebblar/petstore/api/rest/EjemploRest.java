package io.kebblar.petstore.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.model.Factura;
import io.kebblar.petstore.api.service.FacturaService;

@RestController
@RequestMapping(value = "/api")
public class EjemploRest {
	private FacturaService facturaService;
	
	public EjemploRest(FacturaService facturaService) {
		this.facturaService = facturaService;
	}
	
	@GetMapping(path = "/getAll.json", produces = "application/json; charset=utf-8")
    public List<Factura> getAll() throws BusinessException {
        return this.facturaService.getAll();
    }

    @GetMapping(path = "/prueba.json", produces = "application/json; charset=utf-8")
    public Map<String, String> prueba() throws ServletException {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("dato-1", "gus");
        mapa.put("dato-2", "tavo");
        return mapa;
    }
    
    @GetMapping(path = "/prueba2.json", produces = "application/json; charset=utf-8")
    public Map<String, String> prueba2() throws ServletException {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("dato-1", "gus");
        mapa.put("dato-2", "tavo");
        return mapa;
    }


}
