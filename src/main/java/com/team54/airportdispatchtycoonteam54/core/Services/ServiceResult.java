package com.team54.airportdispatchtycoonteam54.core.Services;

public class ServiceResult {
    private final boolean isSuccessfull;
    private final String message;

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
