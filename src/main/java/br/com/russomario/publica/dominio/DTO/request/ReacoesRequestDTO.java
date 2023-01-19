package br.com.russomario.publica.dominio.DTO.request;

import br.com.russomario.publica.dominio.enumeracoes.ReacoesType;

public class ReacoesRequestDTO {

    private Long publicacao_id;
    private Long usuario_id;
    private ReacoesType reacoesType;

    public ReacoesRequestDTO(Long publicacaoId, Long usuarioId, ReacoesType reacoesType) {
        this.publicacao_id = publicacaoId;
        this.usuario_id = usuarioId;
        this.reacoesType = reacoesType;
    }
    

    public ReacoesRequestDTO() {
    }


    public ReacoesType getReacoesType() {
        return reacoesType;
    }

    public void setReacoesType(ReacoesType reacoesType) {
        this.reacoesType = reacoesType;
    }

    public Long getPublicacao_id() {
        return publicacao_id;
    }

    public void setPublicacao_id(Long publicacao_id) {
        this.publicacao_id = publicacao_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

}
