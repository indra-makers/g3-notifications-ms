package com.co.indra.coinmarketcap.notifications.config;

public enum ErrorCodes {

    USER_NOT_FOUND("THERE IS NOT USER BY THAT ID", "002");
    String message;
    String code;

    ErrorCodes(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }


}