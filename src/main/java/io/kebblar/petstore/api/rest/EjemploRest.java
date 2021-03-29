package io.kebblar.petstore.api.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class EjemploRest {

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

    @GetMapping(path = "/prueba3.json", produces = "application/json; charset=utf-8")
    public Map<String, String> prueba3() throws ServletException {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("tarea de", "arquitectura");
        mapa.put("clase", "25 de marzo");
        return mapa;
    }

}
