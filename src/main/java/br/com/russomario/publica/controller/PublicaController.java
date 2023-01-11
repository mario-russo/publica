package br.com.russomario.publica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.DTO.request.PublicacaoRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.PublicacaoRespostaDTO;
import br.com.russomario.publica.service.PublicacaoServiceImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/publica")
public class PublicaController {

    private final PublicacaoServiceImpl service;

    /**
     * @param repository
     * @param usuarioRepository
     */
    public PublicaController(PublicacaoServiceImpl service) {
        this.service = service;
    }

    /**
     * 
     * @param id
     * @return
     *         PublicacaoRespostaDTO(
     *         Long id,
     *         String descricao,
     *         Usuario usuario}
     */
    @GetMapping("/{id}")
    public ResponseEntity<PublicacaoRespostaDTO> buscaId(@PathVariable Long id) {
        var publica = service.buscaId(id);
        return ResponseEntity.ok().body(publica);
    }

    /**
     * Retorna Publicação como Dto
     * 
     * @param publica
     * @return PublicacaoRespostaDTO.class
     */
    @PostMapping
    public ResponseEntity<PublicacaoRespostaDTO> salva(@RequestBody PublicacaoRequestDTO publicaDTO) {
        var publica = service.salvar(publicaDTO);
        return ResponseEntity.created(null).body(publica);
    }

    /**
     * @return List<PublicacaoRespostaDTO>
     */
    @GetMapping
    public ResponseEntity<List<PublicacaoRespostaDTO>> listaTodos() {
        var publica = service.buscaTodos();
        return ResponseEntity.ok().body(publica);
    }

}
