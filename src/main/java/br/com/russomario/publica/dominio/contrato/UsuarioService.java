package br.com.russomario.publica.dominio.contrato;

import java.util.List;

import br.com.russomario.publica.dominio.DTO.request.UsuarioRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.UsuarioRespostaDTO;

/**
 * Interface para Serviço de Usuário
 */
public interface UsuarioService {
    /**
     * Salva Usuário
     * @param usuario
     * @return
     * @throws Exception
     */
    public UsuarioRespostaDTO salvar(UsuarioRequestDTO usuario) throws Exception;
    /**
     * Lista todas os Usuario
     */
    public List<UsuarioRespostaDTO> listaTodos();
    /**
     * @param id
     * @return UsuarioRespostaDTO
     */
    public UsuarioRespostaDTO BuscaId( Long id);
}
