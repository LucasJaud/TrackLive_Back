package com.treacklive.treacklive_api.exception;

public class CpfJaCadastradoException extends RuntimeException {
    public CpfJaCadastradoException(String cpf) {
        super("CPF já cadastrado" + cpf);
    }
}
