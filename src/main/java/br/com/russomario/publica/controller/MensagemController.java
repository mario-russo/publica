package br.com.russomario.publica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.DTO.request.MensagemRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.MensagemRespostaDTO;
import br.com.russomario.publica.dominio.contrato.MensagemService;


@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }
    
    @PostMapping
    public ResponseEntity<MensagemRespostaDTO> salvarMensagem(@RequestBody MensagemRequestDTO mensagemRequestDTO){
        var mensagem =mensagemService.salvar(mensagemRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }
    @GetMapping
    public ResponseEntity< List<MensagemRespostaDTO>> listaTodos(){
        var mensagems =  mensagemService.listaTodos();
        return ResponseEntity.ok().body(mensagems);
    }
}
