package br.com.russomario.publica.dominio.DTO.resposta;

import java.util.List;

import br.com.russomario.publica.dominio.Publicacao;

public class UsuarioRespostaDTO {
    private Long id;
    private String nome;
    private String email;
    private List<Publicacao> publicacao;

    public UsuarioRespostaDTO(Long id, String nome, String email, List<Publicacao> publicacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.publicacao = publicacao;
    }

    public UsuarioRespostaDTO() {
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Publicacao
     */
    public List<Publicacao> getPublicacao() {
        return publicacao;
    }

    /**
     * @param publicacao
     */
    public void setPublicacao(List<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }

}
