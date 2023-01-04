package br.com.russomario.publica.dominio.DTO.resposta;

import br.com.russomario.publica.dominio.Usuario;

public class PublicacaoRespostaDTO {
    private Long id;

    private String descricao;
    private Usuario usuario;

    public PublicacaoRespostaDTO( Long id, String descricao, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
