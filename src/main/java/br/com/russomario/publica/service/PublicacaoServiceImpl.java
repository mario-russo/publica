package br.com.russomario.publica.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.PublicacaoRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.PublicacaoRespostaDTO;
import br.com.russomario.publica.dominio.contrato.PublicacaoService;
import br.com.russomario.publica.repository.PublicacaoRepository;

@Service
public class PublicacaoServiceImpl implements PublicacaoService {
    private final PublicacaoRepository repository;
    private final UsuarioServiceImpl usuarioService;

    public PublicacaoServiceImpl(PublicacaoRepository repository, UsuarioServiceImpl usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.russomario.publica.dominio.contrato.PublicacaoService#salvar(br.com.
     * russomario.publica.dominio.DTO.request.PublicacaoRequestDTO)
     */
    @Override
    public PublicacaoRespostaDTO salvar(PublicacaoRequestDTO publica) {

        Usuario usuario = usuarioService.usuarioEntity(publica.getId());

        Publicacao publicacao = new Publicacao(publica.getDescricao(), usuario);

        Publicacao respostaPublicacao = repository.save(publicacao);

        return new PublicacaoRespostaDTO(respostaPublicacao.getId(), respostaPublicacao.getDescricao(),
                respostaPublicacao.getUsuario());

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.russomario.publica.dominio.contrato.PublicacaoService#buscaTodos()
     */
    @Override
    public List<PublicacaoRespostaDTO> buscaTodos() {

        List<Publicacao> publicacao = repository.findAll();
        
        List<PublicacaoRespostaDTO> publicacaoDTO = publicacao.stream()
                .map(x -> new PublicacaoRespostaDTO(x.getId(), x.getDescricao(), x.getUsuario()))
                .collect(Collectors.toList());
        return publicacaoDTO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.russomario.publica.dominio.contrato.PublicacaoService#buscaId(java.
     * lang.Long)
     */
    @Override
    public PublicacaoRespostaDTO buscaId(Long id) {

        Optional<Publicacao> publicacao = repository.findById(id);

        PublicacaoRespostaDTO publica = new PublicacaoRespostaDTO(publicacao.get().getId(),
                publicacao.get().getDescricao(), publicacao.get().getUsuario());
        return publica;
    }

}
