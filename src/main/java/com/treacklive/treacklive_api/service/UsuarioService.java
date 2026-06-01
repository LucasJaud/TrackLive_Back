package com.treacklive.treacklive_api.service;

import com.treacklive.treacklive_api.dto.UsuarioPerfilDTO;
import com.treacklive.treacklive_api.entity.Cliente;
import com.treacklive.treacklive_api.entity.Usuario;
import com.treacklive.treacklive_api.exception.CredenciaisInvalidasException;
import com.treacklive.treacklive_api.repository.ClienteRepository;
import com.treacklive.treacklive_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public UsuarioPerfilDTO buscarPerfil(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new CredenciaisInvalidasException());

        String cpf = "";
        String endereco = "";
        String telefone = "";

        if (usuario.getTipoUsuario().equals("CLIENTE")) {
            Cliente cliente = clienteRepository.findById(usuario.getId()).orElse(null);
            if (cliente != null) {
                cpf = cliente.getCpf();
                endereco = cliente.getEndereco();
                telefone = cliente.getTelefone();
            }
        }

        return new UsuarioPerfilDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                cpf,
                endereco,
                telefone,
                usuario.getTipoUsuario()
        );
    }
}