package br.com.russomario.publica.dominio;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReacoesPk implements Serializable {

    private final long serialVersionUID = 1L;

    @ManyToOne()
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "publicacao_id",nullable = false)
    private Publicacao publicacao;
    

    public ReacoesPk() {
    }
    


    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((publicacao == null) ? 0 : publicacao.hashCode());
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
        ReacoesPk other = (ReacoesPk) obj;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (publicacao == null) {
            if (other.publicacao != null)
                return false;
        } else if (!publicacao.equals(other.publicacao))
            return false;
        return true;
    }

}
