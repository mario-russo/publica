package br.com.russomario.publica.controller;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.Role;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.LoginDTO;
import br.com.russomario.publica.dominio.DTO.request.UsuarioRequestDTO;
import br.com.russomario.publica.repository.RoleRepository;
import br.com.russomario.publica.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UsuarioRepository usuarioRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository,
            RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {

        if (usuarioRepository.existsByEmail(usuarioRequestDTO.getEmail()))
            return new ResponseEntity<>("Usuario Inválido", HttpStatus.BAD_REQUEST);

        Role role = roleRepository.findByNome("USER");

        var usuario = new Usuario(usuarioRequestDTO.getEmail(), usuarioRequestDTO.getNome());
        usuario.setSenha(passwordEncoder.encode((usuarioRequestDTO.getSenha())));

        usuario.setRole(Collections.singletonList(role));

        System.out.println(usuario);

        usuarioRepository.save(usuario);

        return new ResponseEntity<>("usuario salvo com Sucesso!!!", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDTO login) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getEmail(),
                        login.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("usuario logado", HttpStatus.OK);

    }
}
