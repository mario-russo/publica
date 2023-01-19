package br.com.russomario.publica.dominio;

import br.com.russomario.publica.dominio.enumeracoes.ReacoesType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(ReacoesId.class)
public class Reacoes {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "publicacao_id")
    private Publicacao publicacao;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private ReacoesType reacoesType;

    public Reacoes() {
    }

    public Reacoes(Publicacao publicacao, Usuario usuario, ReacoesType reacoesType) {

        this.publicacao = (publicacao);
        this.usuario = (usuario);
        this.reacoesType = reacoesType;

    }

  
   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((publicacao == null) ? 0 : publicacao.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
        if (publicacao == null) {
            if (other.publicacao != null)
                return false;
        } else if (!publicacao.equals(other.publicacao))
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        return true;
    }

    public ReacoesType getReacoesType() {
        return reacoesType;
    }

    public void setReacoesType(ReacoesType reacoesType) {
        this.reacoesType = reacoesType;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
