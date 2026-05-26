package com.treacklive.treacklive_api.service;

import com.treacklive.treacklive_api.dto.CadastroClienteDTO;
import com.treacklive.treacklive_api.dto.CadastroClienteResponseDTO;
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
import com.treacklive.treacklive_api.exception.EmailJaCadastradoException;
import com.treacklive.treacklive_api.exception.CpfJaCadastradoException;
import com.treacklive.treacklive_api.exception.CredenciaisInvalidasException;
import com.treacklive.treacklive_api.dto.CadastroClienteResponseDTO;

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

    public CadastroClienteResponseDTO cadastrarCliente(CadastroClienteDTO dto) {

        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new EmailJaCadastradoException(dto.getEmail());
        }

        if (clienteRepository.existsByCpf(dto.getCpf())) {
            throw new CpfJaCadastradoException(dto.getCpf());
        }

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(passwordEncoder.encode(dto.getSenha()));
        cliente.setTipoUsuario("CLIENTE");
        cliente.setCpf(dto.getCpf());
        cliente.setEndereco(dto.getEndereco());
        cliente.setTelefone(dto.getTelefone());

        Cliente salvo = clienteRepository.save(cliente);
        
        return new CadastroClienteResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail(),
                salvo.getCpf(),
                salvo.getEndereco(),
                salvo.getTelefone(),
                salvo.getTipoUsuario()

        );
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {

        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new CredenciaisInvalidasException());

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new CredenciaisInvalidasException();
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