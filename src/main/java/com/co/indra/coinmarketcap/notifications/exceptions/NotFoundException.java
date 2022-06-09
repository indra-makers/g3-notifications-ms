package com.co.indra.coinmarketcap.notifications.exceptions;


import com.co.indra.coinmarketcap.notifications.config.ErrorCodes;

public class NotFoundException extends RuntimeException{
    private ErrorCodes bodyCode;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(ErrorCodes bodycode) {
        super(bodycode.getMessage());
        this.bodyCode = bodycode;
    }

    public String getCode() {
        return bodyCode.getCode();
    }
}