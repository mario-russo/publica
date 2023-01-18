package br.com.russomario.publica.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.Reacoes;
import br.com.russomario.publica.repository.ReacoesRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/reacoes")
public class ReacoesController {
    private final ReacoesRepository reacoesRepository;

    public ReacoesController(ReacoesRepository reacoesRepository) {
        this.reacoesRepository = reacoesRepository;
    }

    @PostMapping
    public Reacoes salva (@RequestBody Reacoes reacoes){

        return reacoesRepository.save(reacoes);

    }
    
}
