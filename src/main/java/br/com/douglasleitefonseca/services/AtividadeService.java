package br.com.douglasleitefonseca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglasleitefonseca.domain.Atividade;
import br.com.douglasleitefonseca.repositories.AtividadeRepository;

@Service
public class AtividadeService {
	@Autowired
	private AtividadeRepository repo;
	
	public Atividade buscar(Integer id) {
		Atividade atividade = repo.getById(id);
		return atividade;
	}
	public List<Atividade> all() {
		return repo.findAll();
	}
}
