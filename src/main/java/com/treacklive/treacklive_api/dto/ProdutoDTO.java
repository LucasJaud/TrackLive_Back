package com.treacklive.treacklive_api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private BigDecimal precoAntigo;
    private String categoria;
    private String imagem;
    private String badge;
    private Integer avaliacao;
    private Integer reviews;
}
