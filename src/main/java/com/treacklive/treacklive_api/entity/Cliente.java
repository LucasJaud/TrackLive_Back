package com.treacklive.treacklive_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Clientes")
@PrimaryKeyJoinColumn(name = "id")

public class Cliente extends Usuario{

    @Column(nullable = false, unique = true , length = 11)
    private String cpf;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String telefone;
}
