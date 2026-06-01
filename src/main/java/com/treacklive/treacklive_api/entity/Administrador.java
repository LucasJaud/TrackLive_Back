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
@Table(name = "administradores")
@PrimaryKeyJoinColumn(name = "id")


public class Administrador extends Usuario {

    @Column(name ="Nivel_acesso" , nullable = false)
    private String NivelAcesso;
}
