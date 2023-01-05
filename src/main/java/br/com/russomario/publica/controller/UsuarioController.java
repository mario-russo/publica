package br.com.russomario.publica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russomario.publica.dominio.DTO.request.UsuarioRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.UsuarioRespostaDTO;
import br.com.russomario.publica.dominio.contrato.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    /**
     * @param repository
     */
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    /**
     * @return UsuarioRespostaDTO list
     */
    @GetMapping
    public List<UsuarioRespostaDTO> listaTodos() {
        return service.listaTodos();
    }

    /**
     * @param id
     * @return Usuario
     */
    @GetMapping("/{id}")
    public UsuarioRespostaDTO BuscaId(@PathVariable Long id) {
        return service.BuscaId(id);

    }

    /**
     * @param usuarioDto
     * @return Salvo com Sucesso
     * @throws Exception
     */
    @PostMapping
    public UsuarioRespostaDTO salva(@RequestBody UsuarioRequestDTO usuarioDto) throws Exception {
        return service.salvar(usuarioDto);
    }
}
