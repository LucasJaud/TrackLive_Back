package com.treacklive.treacklive_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CadastroClienteResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String tipoUsuario;
}