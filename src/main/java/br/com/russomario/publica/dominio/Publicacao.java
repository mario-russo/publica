package br.com.russomario.publica.dominio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Classe de Publicão de post
 * 
 * Atributo
 * 
 * Long id;
 * String descricao;
 * Usuario usuario;
 */
@Entity
@Table(name = "publicacao")
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    @OneToMany(mappedBy = "publicacao")
    @JsonBackReference
    private List<Mensagem> mensagem;

    public Publicacao() {
    }

    /**
     * @param descricao
     * @param usuario
     */
    public Publicacao(String descricao, Usuario usuario) {
        this.descricao = descricao;
        this.usuario = usuario;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Descrição da Publicação
     * 
     * @return descição
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
     * 
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

    public List<Mensagem> getMensagem() {
        return mensagem;
    }

    public void setMensagem(List<Mensagem> mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Publicacao other = (Publicacao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
