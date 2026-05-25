package com.treacklive.treacklive_api.controller;

import com.treacklive.treacklive_api.dto.ProdutoDTO;
import com.treacklive.treacklive_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listar(
            @RequestParam(required = false) String categoria) {

        if (categoria != null && !categoria.isBlank()) {
            return ResponseEntity.ok(produtoService.listarPorCategoria(categoria));
        }
        return ResponseEntity.ok(produtoService.listarTodos());
    }
}