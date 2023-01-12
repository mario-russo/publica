package br.com.russomario.publica.dominio.contrato;

import java.util.List;

import br.com.russomario.publica.dominio.DTO.request.MensagemRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.MensagemRespostaDTO;

/**
 * contrato para serviço de mensagem
 */
public interface MensagemService {
    /**
     * @param mensagem
     * @returnMensagemRespostaDTO
     */
    MensagemRespostaDTO salvar(MensagemRequestDTO mensagem);

    /**
     * @return List <MensagemRespostaDTO>
     */
    List<MensagemRespostaDTO> listaTodos();
}
