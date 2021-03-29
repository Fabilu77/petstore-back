package io.kebblar.petstore.api.exception;

public class BusinessException extends Exception {


    public BusinessException(String message) {
        super();
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Exception getHttpError() {
        return null;
    }

    public Object getIdentificador() {
        return null;
    }

    public Object getCveExcepcion() {
        return null;
    }

    public Object getDescExcepcion() {
        return null;
    }
}
