package br.com.russomario.publica.dominio.DTO.resposta;

import java.util.ArrayList;
import java.util.List;

import br.com.russomario.publica.dominio.Mensagem;
import br.com.russomario.publica.dominio.Usuario;
/**
 * Classe de resposta de Publicação
 * 
 * Retorna um DTO da Classe Publicação.
 * 
 * Atributos
 *  -Long id;
    -String descricao;
    -Usuario usuario;
 */
public class PublicacaoRespostaDTO {
    private Long id;

    private String descricao;
    private Usuario usuario;
    private List<Mensagem> mensagem = new ArrayList<>();


    public PublicacaoRespostaDTO( Long id, String descricao, Usuario usuario, List<Mensagem> mensagem) {
        this.id = id;
        setDescricao(descricao); 
        setUsuario(usuario);
        setMensagem(mensagem);
    }

    /**
     * @return
     * -Id da classe DTOs
     */
    public Long getId() {
        return id;
    }
    
    public List<Mensagem> getMensagem() {
        return mensagem;
    }

    public void setMensagem(List<Mensagem> mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return descricao
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
    

}
