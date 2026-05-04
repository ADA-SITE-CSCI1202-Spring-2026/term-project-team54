package com.team54.airportdispatchtycoonteam54.core.Services;

public class ServiceResult {
    private boolean isSuccessfull;
    private String message;

    public ServiceResult(boolean isSuccessfull, String message) {
        this.isSuccessfull = isSuccessfull;
        this.message = message;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public String getMessage() {
        return message;
    }
}
