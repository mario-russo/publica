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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Publicacao> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(List<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }

}
