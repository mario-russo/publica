
package br.com.russomario.publica.dominio.DTO.resposta;

import br.com.russomario.publica.dominio.Mensagem;

public class MensagemRespostaDTO {
    private String conteudo;
    private Long id;

    /**
     * @param conteudo
     * @param id
     */
    public MensagemRespostaDTO(String conteudo, Long id) {
        this.conteudo = conteudo;
        this.id = id;
    }
    

    /**
     * @param mensagem
     */
    public MensagemRespostaDTO(Mensagem mensagem) {
        setConteudo(mensagem.getConteudo());
        setId(mensagem.getId());
    }


    /**
     * @return
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

}
