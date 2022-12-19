
package com.api.deliverymanager.exceptions;

/**
 * Exceção genérica, que é lançada da camada <tt>service</tt>
 */
public class GenericException extends RuntimeException {

    private static final long serialVersionUID = -5997543516314067515L;

    /**
     * Constrói GenericException passando uma mensagem
     *
     * @see {@link Exception#Exception(String)}
     */
    public GenericException(String message) {
        super(message);
    }

    /**
     * Constrói GenericException uma mensagem e sua causa.
     *
     * @see {@link Exception#Exception(String, Throwable)}
     */
    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constrói GenericException com a sua causa.
     *
     * @see {@link Exception#Exception(Throwable)}
     */
    public GenericException(Throwable cause) {
        super(cause);
    }

}
