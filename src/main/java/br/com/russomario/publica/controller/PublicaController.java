package br.com.russomario.publica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.repository.PublicacaoRepository;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/publica")
public class PublicaController {

    private final PublicacaoRepository repository;

    public PublicaController(PublicacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Publicacao buscaId(@PathVariable Long id) {
        Optional<Publicacao> publicacao = repository.findById(id);
        return publicacao.get();
    }

    @PostMapping
    public Publicacao salva(@RequestBody Publicacao publicacao) {
        Publicacao respostaPublicacao = repository.save(publicacao);
        return respostaPublicacao;
    }

}
