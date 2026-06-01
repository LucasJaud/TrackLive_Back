package com.treacklive.treacklive_api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class CadastroClienteDTO {

    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email invalido")
    private String email;

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11 , max = 11, message = "CPF deve ter 11 Digitos")
    private String cpf;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "senha deve ter no minimo 6 caracteres")
    private String senha;

    @NotBlank(message = "endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "Telefone é Obrigatório")
    @Size(min = 10, max = 11, message = "O Telefone deve ter de 10 a 11 dígitos")
    private String Telefone;
}
