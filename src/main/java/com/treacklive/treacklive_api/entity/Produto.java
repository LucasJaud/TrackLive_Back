package com.treacklive.treacklive_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "preco_antigo", precision = 10, scale = 2)
    private BigDecimal precoAntigo;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String imagem;

    private String badge;

    @Column(nullable = false)
    private Integer avaliacao;

    @Column(nullable = false)
    private Integer reviews;

    @Column(nullable = false)
    private boolean ativo = true;
}