package br.com.russomario.publica.dominio.DTO.resposta;

import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Reacoes;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.enumeracoes.ReacoesType;

public class    ReacoesRepostaDto {
    private Usuario usuario;
    private Publicacao publicacao;
    private ReacoesType reacoesType;

    public ReacoesRepostaDto(Reacoes reacoes) {
        usuario = reacoes.getUsuario();
        publicacao = reacoes.getPublicacao();
        reacoesType = reacoes.getReacoesType();

    }

    public ReacoesRepostaDto() {
    }

    public ReacoesType getReacoesType() {
        return reacoesType;
    }

    public void setReacoesType(ReacoesType reacoesType) {
        this.reacoesType = reacoesType;
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

}
