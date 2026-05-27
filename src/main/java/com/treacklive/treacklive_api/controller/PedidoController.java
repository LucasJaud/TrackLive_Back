package com.treacklive.treacklive_api.controller;

import com.treacklive.treacklive_api.dto.PedidoRequestDTO;
import com.treacklive.treacklive_api.dto.PedidoResponseDTO;
import com.treacklive.treacklive_api.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(
            Authentication authentication,
            @Valid @RequestBody PedidoRequestDTO dto) {

        String email = authentication.getName();
        PedidoResponseDTO resposta = pedidoService.criarPedido(email, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}