package br.com.russomario.publica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<ReacoesRepostaDto> salva (@RequestBody ReacoesRequestDTO reacoes){
        ReacoesRepostaDto reacoeSalva = serviceImpler.salvar(reacoes);
        return ResponseEntity.status(HttpStatus.CREATED).body(reacoeSalva);

    }
     @GetMapping
     public ResponseEntity<List<ReacoesRepostaDto>> listaTodos(){
        List<ReacoesRepostaDto> reacoes = serviceImpler.listaTodos();
        return ResponseEntity.ok().body(reacoes);
     }
    
}
