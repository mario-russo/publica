package br.com.russomario.publica.dominio.DTO.request;

public class PublicacaoRequestDTO {

    private String descricao;
    private Long id;

    public PublicacaoRequestDTO(String descricao, Long id) {
        this.descricao = descricao;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

}
