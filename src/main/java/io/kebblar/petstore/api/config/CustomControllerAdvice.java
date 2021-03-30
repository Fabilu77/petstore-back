/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Paquete:     mx.qbits.unam.proyecto.api.controller
 * Modulo:      cinepolis
 * Tipo:        clase
 * Autor:       Chandra Nichdali QUintas de la Parra
 * Fecha:       14 de Marzo de 2020
 * Version:    1.0-SNAPSHOT
 * .
 * Clase encargada de controlar las excepciones
 */
package io.kebblar.petstore.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.exceptions.UploadException;

/**
 * Controlador que manejara las excepciones lanzadas por los demas
 * controladores.
 */
@ControllerAdvice
public class CustomControllerAdvice {
    private Logger logger = LoggerFactory.getLogger(CustomControllerAdvice.class);

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> userErrorHandler(MethodArgumentNotValidException geEx) {
        logger.error(getStackTraceExStr(geEx));
        // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400
        return new ResponseEntity<>(buildValidationErrorResponse(geEx), HttpStatus.ACCEPTED);
    }

    /**
     * Método que maneja las exepciones de {@link GenericaException}.
     *
     * @param geEx la excepcion que manejara
     * @return un diccionario con los valores a mostrarse en el JSON de salida
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Map<String, Object>> errorHandler(BusinessException geEx) {
        logger.error(getStackTraceExStr(geEx));
        return new ResponseEntity<>(crearMapaRetorno(geEx), geEx.getHttpError());
    }

    /**
     * Método que maneja las excepciones de tipo {@link UploadException}.
     *
     * @param geEx la excepcion que manejara
     * @return un diccionario con los valores que mostrara el JSON de salida
     */
    @ResponseBody
    @ExceptionHandler(value = UploadException.class)
    public ResponseEntity<Map<String, Object>> errorHandlerUploadException(UploadException geEx) {
        logger.error(geEx.getDescExcepcion());
        return new ResponseEntity<>(crearMapaRetorno(geEx), HttpStatus.BAD_REQUEST);
    }

    /**
     * Mapa de retorno para errores de tipo MethodArgumentNotValidException
     * 
     * @param geEx la excepcion a mapear
     * @return
     */
    private Map<String, Object> buildValidationErrorResponse(MethodArgumentNotValidException geEx) {
        BindingResult binding = geEx.getBindingResult();
        Map<String, Object> map = new HashMap<>();
        List<Map<String, String>> lista = new ArrayList<>();
        for (ObjectError fe : binding.getAllErrors()) {
            FieldError error = (FieldError)fe;
            Map<String, String> err = new HashMap<>();
                String defMess = error.getDefaultMessage();
                String[] arr = defMess.split("\\|");
                
                String index = (arr.length>1)? arr[1]:"0";
            err.put("index", index);
            err.put("description", arr[0]);
            
            err.put("validation-type", error.getCode()); 
            err.put("object-name", error.getObjectName());
            err.put("rejected-value", error.getRejectedValue()+"");
            err.put("field-name", error.getField());
            lista.add(err);
        }
        map.put("TipoError", "1777");
        map.put("errors", lista);
        return map;
    }

    /**
     * Método auxiliar que crea el objeto a mostrarse cuando se lance la excepcion.
     *
     * @param ex la excepcion a mapear
     * @return el diccionario con la excepcion mapeada
     */
    private Map<String, Object> crearMapaRetorno(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        if (ex instanceof BusinessException) {
            BusinessException ad = (BusinessException) (ex);
            map.put("tipo-error", ad.getIdentificador());
            map.put("cve-exception", ad.getCveExcepcion());
            map.put("http-error", ad.getHttpError());
            map.put("desc-exception", ad.getDescExcepcion());
        }
        return map;
    }

    /**
     * Método auxiliar que obtiene a traza de la excepcion completa.
     *
     * @param excepcion la excepcion que se debe rastrear
     * @return su representacion en string
     */
    private String getStackTraceExStr(Exception excepcion) {
        StringBuilder errorGenerica = new StringBuilder();
        if (excepcion instanceof BusinessException) {
            BusinessException ge = (BusinessException) (excepcion);
            errorGenerica.append("tipo: ");
            errorGenerica.append(ge.getIdentificador());
            errorGenerica.append(": ");
            errorGenerica.append(ge.getCveExcepcion());
            errorGenerica.append(": ");
            errorGenerica.append(ge.getDescExcepcion());
            StringWriter errores = new StringWriter();
            ge.printStackTrace(new PrintWriter(errores));
            errorGenerica.append("\n");
        }
        return errorGenerica.toString();
    }

}
