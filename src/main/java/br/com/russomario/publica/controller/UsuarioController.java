package br.com.russomario.publica.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.UsuarioRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.UsuarioRespostaDTO;
import br.com.russomario.publica.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;

    /**
     * @param repository
     */
    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    /**
     * @return UsuarioRespostaDTO list
     */
    @GetMapping
    public List<UsuarioRespostaDTO> listaTodos() {
        List<Usuario> reposta = repository.findAll();
        List<UsuarioRespostaDTO> usuario = reposta.stream()
                .map(x -> new UsuarioRespostaDTO(x.getId(), x.getNome(), x.getEmail(), x.getPublicacao()))
                .collect(Collectors.toList());
        return usuario;
    }

    /**
     * @param id
     * @return Usuario
     */
    @GetMapping("/{id}")
    public Usuario BuscaId(@PathVariable Long id) {
        Optional<Usuario> repostaUsuario = repository.findById(id);
        return repostaUsuario.get();

    }

    /**
     * @param usuarioDto
     * @return Salvo com Sucesso
     */
    @PostMapping
    public String salva(@RequestBody UsuarioRequestDTO usuarioDto) {
        Usuario usuario = new Usuario(usuarioDto.getNome(), usuarioDto.getEmail());
        Usuario usuarioSalvo = repository.save(usuario);
        if (Objects.isNull(usuarioSalvo)) {
            return "Erro Ao Salvar";
        }
        return "Salvo com Sucesso";
    }
}
