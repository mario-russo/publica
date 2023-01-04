package br.com.russomario.publica.dominio.DTO.resposta;

import br.com.russomario.publica.dominio.Usuario;
/**
 * Classe de resposta de Publicação
 * 
 * Retorna um DTO da Classe Publicação.
 * 
 * Atributos
 *  -Long id;
    -String descricao;
    -Usuario usuario;
 */
public class PublicacaoRespostaDTO {
    private Long id;

    private String descricao;
    private Usuario usuario;

    public PublicacaoRespostaDTO( Long id, String descricao, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    /**
     * @return
     * -Id da classe DTOs
     */
    public Long getId() {
        return id;
    }

    /**
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
