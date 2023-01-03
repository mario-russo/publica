package br.com.russomario.publica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.russomario.publica.dominio.Publicacao;
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {

}
