
package br.com.russomario.publica.dominio.DTO.request;

public class MensagemRequestDTO {

    private String conteudo;

    /**
     * @param conteudo
     */
    public MensagemRequestDTO(String conteudo) {
        setConteudo(conteudo);
        ;
    }

    public MensagemRequestDTO() {
    }

    /**
     * @return
     *         String com a mensagem
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

}
