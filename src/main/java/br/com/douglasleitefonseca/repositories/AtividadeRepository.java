package br.com.douglasleitefonseca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.douglasleitefonseca.domain.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade,Integer>{
	public List<Atividade> findByNomeContainingIgnoreCase(@Param("nome") String nome);
	public Atividade getById(@Param("id") Integer id);
}
