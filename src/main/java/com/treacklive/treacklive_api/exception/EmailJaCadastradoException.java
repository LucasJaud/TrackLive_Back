package com.treacklive.treacklive_api.exception;

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException(String email){
        super("Email já cadastrado:" + email);
    }
}
