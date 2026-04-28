package com.treacklive.treacklive_api.repository;

import com.treacklive.treacklive_api.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao , Long>{
    Optional<Sessao> findByUsuarioIdAndAtiveTrue(Long usuarioId);

}
