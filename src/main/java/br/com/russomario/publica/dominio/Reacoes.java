package br.com.russomario.publica.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.russomario.publica.dominio.enumeracoes.ReacoesType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Reacoes implements Serializable {

    private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    ReacoesType tipo;

    @ManyToMany(mappedBy = "")
    @JsonBackReference
    Set<Usuario> usuario = new HashSet<>();

    @ManyToMany(mappedBy = "reacoes")
    @JsonBackReference
    Set<Publicacao> publicacao = new HashSet<>();

    public Reacoes(long id, ReacoesType tipo, Set<Usuario> usuario, Set<Publicacao> publicacao) {
        this.id = id;
        this.tipo = tipo;
        this.usuario = usuario;
        this.publicacao = publicacao;
    }

    public Reacoes() {
    }

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return ReacoesType
     */
    public ReacoesType getTipo() {
        return tipo;
    }

    /**
     * @param tipo
     */
   

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param tipo
     */
    public void setTipo(ReacoesType tipo) {
        this.tipo = tipo;
    }

    /**
     * @return Usuario
     */
    public Set<Usuario> getUsuario() {
        return usuario;
    }

    /**
     * @param usuario
     */
    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    /**
     * @return Publicacao
     */
    public Set<Publicacao> getPublicacao() {
        return publicacao;
    }

    /**
     * @param publicacao
     */
    public void setPublicacao(Set<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }

    

}
