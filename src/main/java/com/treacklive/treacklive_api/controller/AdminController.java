package com.treacklive.treacklive_api.controller;

import com.treacklive.treacklive_api.dto.AdminUsuarioDTO;
import com.treacklive.treacklive_api.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<AdminUsuarioDTO>> listarUsuarios() {
        return ResponseEntity.ok(adminService.listarUsuarios());
    }
}