package br.com.russomario.publica.dominio.DTO.request;

/**
 * Classe de entrada da classe publicação
 * Atributos
 * -String descricao
 * -Long id
 */
public class PublicacaoRequestDTO {

    private String descricao;
    private Long id;

    /**
     * Construtor da classe
     * 
     * @param descricao
     * @param id
     */
    public PublicacaoRequestDTO(String descricao, Long id) {
        this.descricao = descricao;
        this.id = id;
    }

    /**
     * @return descricão
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricão
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return id do da calsse
     */
    public Long getId() {
        return id;
    }

}
