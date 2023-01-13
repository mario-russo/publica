
package br.com.russomario.publica.dominio.DTO.request;

public class MensagemRequestDTO {

    private String conteudo;
    private Long publicacaoId;
    private Long usuarioId;

    /**
     * @param conteudo
     */
    public MensagemRequestDTO(String conteudo, Long publicacaoId,Long usuarioid) {
        setConteudo(conteudo);
        setPublicacaoId(publicacaoId);
        setUsuarioId(usuarioid);
    }

    public MensagemRequestDTO() {
    }

    /**
     * @return
     */
    public Long getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId
     */
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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

    /**
     * @return
     *         publicacaoId
     */
    public Long getPublicacaoId() {
        return publicacaoId;
    }

    /**
     * @param publicacaoId
     */
    public void setPublicacaoId(Long publicacaoId) {
        this.publicacaoId = publicacaoId;
    }

}
