package br.com.russomario.publica.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.DTO.request.ReacoesRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.ReacoesRepostaDto;
import br.com.russomario.publica.service.ReacoesServiceImpl;
@RestController
@RequestMapping("/reacoes")
public class ReacoesController {

    private final ReacoesServiceImpl serviceImpler;


    public ReacoesController(ReacoesServiceImpl service) {
        this.serviceImpler = service;
    }

    @PostMapping
    public ReacoesRepostaDto salva (@RequestBody ReacoesRequestDTO reacoes){
        ReacoesRepostaDto reacoeSalva = serviceImpler.salvar(reacoes);
        return reacoeSalva;

    }
    
}
