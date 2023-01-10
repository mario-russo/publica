package br.com.russomario.publica.dominio.DTO.request;

public class UsuarioRequestDTO {
    private String nome;
    private String email;
    
    public UsuarioRequestDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    public UsuarioRequestDTO() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
