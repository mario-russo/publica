
package br.com.russomario.publica.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.russomario.publica.dominio.Mensagem;
import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.MensagemRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.MensagemRespostaDTO;
import br.com.russomario.publica.dominio.contrato.MensagemService;
import br.com.russomario.publica.repository.MensagemRepository;

@Service
public class MensagemServiceIml implements MensagemService {

    private final MensagemRepository mensagemRepository;
    private final PublicacaoServiceImpl publicacaoService;
    private final UsuarioServiceImpl usuarioService;

    public MensagemServiceIml(MensagemRepository mensagemRepository, PublicacaoServiceImpl publicacaoServiceImpl, UsuarioServiceImpl usuarioService) {
        this.mensagemRepository = mensagemRepository;
        this.publicacaoService = publicacaoServiceImpl;
        this.usuarioService = usuarioService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.russomario.publica.dominio.contrato.MensagemService#salvar(br.com.
     * russomario.publica.dominio.DTO.request.MensagemRequestDTO)
     * Implemantação concreta do método
     */
    @Override
    public MensagemRespostaDTO salvar(MensagemRequestDTO mensagemDto) {

        Publicacao publicacao = publicacaoService.getPublicacao(mensagemDto.getPublicacaoId());
        Usuario usuario = usuarioService.usuarioEntity(mensagemDto.getUsuarioId());

        Mensagem mensagem = new Mensagem(mensagemDto.getConteudo());

        mensagem.setPublicacao(publicacao);
        mensagem.setUsuario(usuario);

        var mensagemSalva = mensagemRepository.save(mensagem);
        var mensagemDTO = new MensagemRespostaDTO(mensagemSalva);

        return mensagemDTO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.russomario.publica.dominio.contrato.MensagemService#listaTodos()]
     * Implemantação concreta do método
     */
    @Override
    public List<MensagemRespostaDTO> listaTodos() {
        List<Mensagem> mensagems = mensagemRepository.findAll();
        var mensagemsDTO = mensagems.stream().map(item -> new MensagemRespostaDTO(item)).collect(Collectors.toList());
        return mensagemsDTO;
    }

}
