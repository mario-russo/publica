package br.com.russomario.publica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @param service
     */
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    /**
     * @return UsuarioRespostaDTO list
     */
    @GetMapping
    public ResponseEntity<List<UsuarioRespostaDTO>> listaTodos() {
        var usuarioLista = service.listaTodos();
        return ResponseEntity.status(200).body(usuarioLista);
    }

    /**
     * @param id
     * @return Usuario
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRespostaDTO> BuscaId(@PathVariable Long id) {
        var usuario = service.BuscaId(id);
        return ResponseEntity.ok().body(usuario);
    }

    /**
     * @param usuarioDto
     * @return Salvo com Sucesso
     * @throws Exception
     */
    @PostMapping
    public ResponseEntity<UsuarioRespostaDTO> salva(@RequestBody UsuarioRequestDTO usuarioDto) throws Exception {
        var usuarioCreated = service.salvar(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreated);
    }
}
