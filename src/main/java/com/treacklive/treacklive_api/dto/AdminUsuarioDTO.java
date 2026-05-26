package com.treacklive.treacklive_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminUsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String tipoUsuario;
}