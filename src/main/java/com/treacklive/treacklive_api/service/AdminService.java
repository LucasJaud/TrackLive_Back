package com.treacklive.treacklive_api.service;

import com.treacklive.treacklive_api.dto.AdminUsuarioDTO;
import com.treacklive.treacklive_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<AdminUsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new AdminUsuarioDTO(
                        u.getId(),
                        u.getNome(),
                        u.getEmail(),
                        u.getTipoUsuario()
                ))
                .toList();
    }
}