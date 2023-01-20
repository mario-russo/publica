package br.com.russomario.publica.jwt.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.UsuarioRequestDTO;
import br.com.russomario.publica.dominio.enumeracoes.Role;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UsuarioRequestDTO request) {
                Usuario usuario = new Usuario(request.getNome(), request.getEmail(), request.getSenha());
                usuario.setRole(Role.USER);
        return null;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        return null;
    }
}
