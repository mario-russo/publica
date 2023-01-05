package br.com.russomario.publica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.DTO.request.PublicacaoRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.PublicacaoRespostaDTO;
import br.com.russomario.publica.service.PublicacaoServiceImpl;

import java.util.List;

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
    public PublicacaoRespostaDTO buscaId(@PathVariable Long id) {
        return service.buscaId(id);
    }

    /**
     * Retorna Publicação como Dto
     * 
     * @param publica
     * @return PublicacaoRespostaDTO.class
     */
    @PostMapping
    public PublicacaoRespostaDTO salva(@RequestBody PublicacaoRequestDTO publica) {
        return service.salvar(publica);
    }

    /**
     * @return List<PublicacaoRespostaDTO>
     */
    @GetMapping
    public List<PublicacaoRespostaDTO> listaTodos() {
        return service.buscaTodos();
    }

}
