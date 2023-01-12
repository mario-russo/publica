package br.com.russomario.publica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.russomario.publica.dominio.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
