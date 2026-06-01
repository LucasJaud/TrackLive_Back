package com.treacklive.treacklive_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PedidoResponseDTO {
    private Long id;
    private String status;
    private BigDecimal total;
    private LocalDateTime dataPedido;
    private int quantidadeItens;
}