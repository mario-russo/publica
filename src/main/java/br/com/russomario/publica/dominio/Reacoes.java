package br.com.russomario.publica.dominio;

// import java.io.Serializable;

import br.com.russomario.publica.dominio.enumeracoes.ReacoesType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Reacoes{


    @EmbeddedId
    @Column(insertable=false, updatable=false)
    private ReacoesPk id = new ReacoesPk();

    ReacoesType reacoesType;

    public Reacoes() {
    }

    public Reacoes(ReacoesType reacoesType, Publicacao publicacao, Usuario usuario) {
        this.reacoesType = reacoesType;
        this.id.setPublicacao(publicacao);
        this.id.setUsuario(usuario);
    }

    public Usuario getUsuario() {
        return this.id.getUsuario();
    }

    public void setUsuario(Usuario usuario) {
        this.id.setUsuario(usuario);
    }

    public Publicacao getPublicacao() {
        return this.id.getPublicacao();
    }

    public void setPublicacao(Publicacao publicacao) {
        this.id.setPublicacao(publicacao);
    }

    public ReacoesType getReacoesType() {
        return reacoesType;
    }

    public void setReacoesType(ReacoesType reacoesType) {
        this.reacoesType = reacoesType;
    }

    // public long getSerialVersionUID() {
    //     return serialVersionUID;
    // }

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
        Reacoes other = (Reacoes) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
