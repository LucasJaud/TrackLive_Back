package com.treacklive.treacklive_api.exception;

public class CredenciaisInvalidasException extends RuntimeException {
    public CredenciaisInvalidasException() {
        super("Email ou senha Incorretos");
    }
}
