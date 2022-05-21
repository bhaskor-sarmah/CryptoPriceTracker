package com.bhaskor.CryptoPriceTracker.Response;

public class ErrorResponse {
    
    String message;

    int httpStatusCode;

    Object payload;


    public ErrorResponse() {
    }


    public ErrorResponse(String message, int httpStatusCode, Object payload) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
        this.payload = payload;
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public Object getPayload() {
        return this.payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

}
