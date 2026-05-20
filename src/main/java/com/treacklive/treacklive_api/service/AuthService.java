package com.treacklive.treacklive_api.service;

import com.treacklive.treacklive_api.dto.CadastroClienteDTO;
import com.treacklive.treacklive_api.dto.LoginRequestDTO;
import com.treacklive.treacklive_api.dto.LoginResponseDTO;
import com.treacklive.treacklive_api.entity.Cliente;
import com.treacklive.treacklive_api.entity.Usuario;
import com.treacklive.treacklive_api.repository.ClienteRepository;
import com.treacklive.treacklive_api.repository.UsuarioRepository;
import com.treacklive.treacklive_api.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Cliente cadastrarCliente(CadastroClienteDTO dto) {

        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado!");
        }

        if (clienteRepository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(passwordEncoder.encode(dto.getSenha()));
        cliente.setTipoUsuario("CLIENTE");
        cliente.setCpf(dto.getCpf());
        cliente.setEndereco("");
        cliente.setTelefone("");

        return clienteRepository.save(cliente);
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {

        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta!");
        }

        String token = jwtService.gerarToken(usuario.getEmail(), usuario.getTipoUsuario());

        return new LoginResponseDTO(
                token,
                "Bearer",
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario()
        );
    }
}