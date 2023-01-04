package br.com.russomario.publica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.PublicacaoRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.PublicacaoRespostaDTO;
import br.com.russomario.publica.repository.PublicacaoRepository;
import br.com.russomario.publica.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/publica")
public class PublicaController {

    private final PublicacaoRepository repository;
    private final UsuarioRepository usuarioRepository;

    public PublicaController(PublicacaoRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/{id}")
    public PublicacaoRespostaDTO buscaId(@PathVariable Long id) {
        Optional<Publicacao> publicacao = repository.findById(id);

        PublicacaoRespostaDTO publica = new PublicacaoRespostaDTO(publicacao.get().getId(),
                publicacao.get().getDescricao(), publicacao.get().getUsuario());
        return publica;
    }

    @PostMapping
    public Publicacao salva(@RequestBody PublicacaoRequestDTO publica) {
        Optional<Usuario >usuarioId = usuarioRepository.findById(publica.getId());
        Publicacao publicacao = new Publicacao(publica.getDescricao(), usuarioId.get());
        Publicacao respostaPublicacao = repository.save(publicacao);
        return respostaPublicacao;
    }

    @GetMapping
    public List<PublicacaoRespostaDTO> listaTodos(){
        List<Publicacao> publicacao = repository.findAll();
        List<PublicacaoRespostaDTO> publicacaoDTO = publicacao.stream().map(x-> new PublicacaoRespostaDTO(x.getId(),x.getDescricao(),x.getUsuario())).collect(Collectors.toList()); 
        return publicacaoDTO;
    }

}
