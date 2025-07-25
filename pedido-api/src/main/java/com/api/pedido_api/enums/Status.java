package com.api.pedido_api.enums;

public enum Status {
    PAGO(1),
    NAO_PAGO(2);

    private Integer code;

    Status(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static Status valueOf(Integer code) {
        for (Status value : Status.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status Code");
    }
}
