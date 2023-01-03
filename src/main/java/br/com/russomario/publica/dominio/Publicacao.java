package br.com.russomario.publica.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Publicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @NotNull
    private String descricao;
    // private Usuario usuario;

    public Publicacao() {
    }

    public Publicacao(String descricao, Usuario usuario) {
        this.descricao = descricao;
        // this.usuario = usuario;
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

}
