package com.treacklive.treacklive_api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
public class PedidoRequestDTO {

    @NotEmpty(message = "O pedido deve ter ao menos um item")
    private List<ItemPedidoRequestDTO> itens;
}
