package br.com.russomario.publica.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String conteudo;

    public Mensagem() {
    }

    /**
     * @param conteudo
     */
    public Mensagem(String conteudo) {
        setConteudo(conteudo);
    }

    /**
     * @return
     *         Id da mensagem
     */
    public Long getId() {
        return id;
    }

    /**
     * @return
     *         String contendo Conteud da mensagem
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
