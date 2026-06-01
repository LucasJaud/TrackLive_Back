package com.treacklive.treacklive_api.repository;

import com.treacklive.treacklive_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface ClienteRepository extends JpaRepository< Cliente , Long> {

    Optional<Cliente> findByCpf(String cpf);

    boolean existsByCpf(String cpf);
}
