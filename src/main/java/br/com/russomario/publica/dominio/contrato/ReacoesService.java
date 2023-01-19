package br.com.russomario.publica.dominio.contrato;

import br.com.russomario.publica.dominio.DTO.request.ReacoesRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.ReacoesRepostaDto;

public interface ReacoesService {
    /**
     * @param dto
     * @return ReacoesrepostaDto
     */
    public ReacoesRepostaDto salvar(ReacoesRequestDTO dto);

    /**
     * retorna todas as Reacoes
     * @return Lista de Reacões
     */
    public ReacoesRepostaDto listaTodos();

}
