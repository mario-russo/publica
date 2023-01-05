package br.com.russomario.publica.dominio.contrato;

import java.util.List;

import br.com.russomario.publica.dominio.DTO.request.PublicacaoRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.PublicacaoRespostaDTO;
/**
 * Contrato Para implementar Serviço de Publicação 
 * @author Mário Russo
 */
public interface PublicacaoService {
    /**
     * @param publicação
     * @return PublicacaoRespostaDTO
     */
    public PublicacaoRespostaDTO salvar(PublicacaoRequestDTO publicação);
    /**
     * @return  List<PublicacaoRespostaDTO>
     */
    public List<PublicacaoRespostaDTO> buscaTodos();

    /**
     * @param id
     * @return PublicacaoRespostaDTO
     */
    public PublicacaoRespostaDTO buscaId(Long id);
}
