package com.treacklive.treacklive_api.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException(Long id) {
        super("Produto não encontrado com id:" + id);
    };

}
