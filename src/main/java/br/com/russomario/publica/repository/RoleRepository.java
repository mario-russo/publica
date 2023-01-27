package br.com.russomario.publica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.russomario.publica.dominio.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
    public Role findByNome(String nome);
    
}
