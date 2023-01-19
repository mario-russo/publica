package br.com.russomario.publica.dominio;

public class ReacoesId {
    
    private Long usuario;
    private Long publicacao;

    public ReacoesId(Long usuario, Long publicacao) {
        this.usuario = usuario;
        this.publicacao = publicacao;
    }

    public ReacoesId() {
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Long publicacao) {
        this.publicacao = publicacao;
    }

}
