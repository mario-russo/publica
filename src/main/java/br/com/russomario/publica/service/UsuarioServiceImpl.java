package br.com.russomario.publica.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.UsuarioRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.UsuarioRespostaDTO;
import br.com.russomario.publica.dominio.contrato.UsuarioService;
import br.com.russomario.publica.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.russomario.publica.dominio.contrato.UsuarioService#salvar(br.com.
     * russomario.publica.dominio.DTO.request.UsuarioRequestDTO)
     */
    @Override
    public UsuarioRespostaDTO salvar(UsuarioRequestDTO usuarioDto) throws Exception {
        
        Usuario usuario = new Usuario(usuarioDto.getNome(), usuarioDto.getEmail());
        Usuario usuarioSalvo = repository.save(usuario);

        if (Objects.isNull(usuarioSalvo)) {
            throw new Exception("Erro o Salva Usuário");
        }

        UsuarioRespostaDTO usuarioRespostaDTO = new UsuarioRespostaDTO(usuarioSalvo.getId(), usuarioSalvo.getNome(),
                usuarioSalvo.getEmail(),
                usuarioSalvo.getPublicacao());

        return usuarioRespostaDTO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.russomario.publica.dominio.contrato.UsuarioService#listaTodos()
     */
    @Override
    public List<UsuarioRespostaDTO> listaTodos() {

        List<Usuario> reposta = repository.findAll();

        List<UsuarioRespostaDTO> usuario = reposta.stream()
                .map(x -> new UsuarioRespostaDTO(x.getId(), x.getNome(), x.getEmail(), x.getPublicacao()))
                .collect(Collectors.toList());

        return usuario;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.russomario.publica.dominio.contrato.UsuarioService#BuscaId(java.lang.
     * Long)
     */
    @Override
    public UsuarioRespostaDTO BuscaId(Long id) {

        Optional<Usuario> repostaUsuario = repository.findById(id);

        UsuarioRespostaDTO usuario = new UsuarioRespostaDTO(repostaUsuario.get().getId(),
                repostaUsuario.get().getNome(),
                repostaUsuario.get().getEmail(), repostaUsuario.get().getPublicacao());

        return usuario;
    }

    public Usuario usuarioEntity(Long id) {
        return repository.findById(id).get();
    }

}
