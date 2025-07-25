package com.api.pedido_api.services.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public ResourceNotFoundException(UUID id) {
        super("Resource not found. Id: " + id);
    }
}
