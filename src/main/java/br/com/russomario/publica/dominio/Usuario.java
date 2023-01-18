package br.com.russomario.publica.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Classe do usuario
 * 
 * Atributos
 * private Long id;
 * private String nome;
 * private String email;
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private List<Publicacao> publicacao;

    @OneToMany(mappedBy = "id.usuario" )
    @JsonManagedReference
    @JsonIgnore
    private Set<Reacoes> reacoes = new HashSet<>();

    public Usuario() {
    }

    /**
     * @return serialVersionUID
     */
    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param nome
     * @param email
     */
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
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
     * @return
     *         E-mail
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
     * @return
     */
    public List<Publicacao> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(List<Publicacao> publicacao) {
        this.publicacao = publicacao;
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
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
