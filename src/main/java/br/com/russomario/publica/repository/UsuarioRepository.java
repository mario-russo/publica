package br.com.russomario.publica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.russomario.publica.dominio.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String Email);
    Boolean existsByEmail(String email);
}
