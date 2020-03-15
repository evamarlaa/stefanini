package com.example.stefanini.exception;

public class PersonResourceException extends Exception {

    private static final long serialVersionUID = 588070720381025499L;

    public PersonResourceException() {
        super();
    }

    public PersonResourceException(String message, Throwable cause, boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PersonResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonResourceException(String message) {
        super(message);
    }

    public PersonResourceException(Throwable cause) {
        super(cause);
    }
}
