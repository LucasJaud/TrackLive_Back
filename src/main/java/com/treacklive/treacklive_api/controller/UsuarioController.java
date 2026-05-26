package com.treacklive.treacklive_api.controller;

import com.treacklive.treacklive_api.dto.UsuarioPerfilDTO;
import com.treacklive.treacklive_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil")
    public ResponseEntity<UsuarioPerfilDTO> perfil(Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok(usuarioService.buscarPerfil(email));
    }
}
