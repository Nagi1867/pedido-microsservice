package com.api.pedido_api.services.exceptions;

public class DatabaseException extends RuntimeException{
    private static final long SerialVersionUID = 1L;

    public DatabaseException(String msg) {
        super(msg);
    }
}
