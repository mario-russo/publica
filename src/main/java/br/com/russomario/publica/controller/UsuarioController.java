package br.com.russomario.publica.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Usuario> listaTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario BuscaId(@PathVariable Long id) {
        Optional<Usuario> repostaUsuario = repository.findById(id);
        return repostaUsuario.get();

    }

    @PostMapping
    public String salva(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = repository.save(usuario);
        if (Objects.isNull(usuarioSalvo)) {
            return "Erro Ao Salvar";
        }
        return "Salvo com Sucesso";
    }
}
