package com.treacklive.treacklive_api.repository;

import com.treacklive.treacklive_api.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdministradorRepository extends JpaRepository<Administrador,Long> {
}
