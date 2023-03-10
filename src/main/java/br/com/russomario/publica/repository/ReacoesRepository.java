package br.com.russomario.publica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Reacoes;

public interface ReacoesRepository extends JpaRepository<Reacoes,Long>{
   public Reacoes findByPublicacao(Publicacao publicacao);
    
}
