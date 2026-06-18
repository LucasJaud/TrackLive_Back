package com.treacklive.treacklive_api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class LoginRequestDTO {


    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email invalido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

}
