package com.treacklive.treacklive_api.controller;

import com.treacklive.treacklive_api.dto.CadastroClienteDTO;
import com.treacklive.treacklive_api.dto.LoginRequestDTO;
import com.treacklive.treacklive_api.dto.LoginResponseDTO;
import com.treacklive.treacklive_api.entity.Cliente;
import com.treacklive.treacklive_api.service.AuthService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Cliente> registrar(@Valid @RequestBody CadastroClienteDTO request) {
        Cliente clienteCriado = authService.cadastrarCliente(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        LoginResponseDTO resposta = authService.login(request);
        return ResponseEntity.ok(resposta);
    }
}