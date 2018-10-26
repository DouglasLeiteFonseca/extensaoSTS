package br.com.douglasleitefonseca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.douglasleitefonseca.domain.Atividade;
import br.com.douglasleitefonseca.repositories.AtividadeRepository;

@Service
public class AtividadeService {
	@Autowired
	private AtividadeRepository repo;
	
	public Atividade buscar(Integer id) {
		Optional<Atividade> atividade = repo.findById(id);
		if(atividade.isPresent()) {
			return atividade.get();
		}
		
		return null;
	}
	public Page<Atividade> all(int page, int size) {
		return repo.findAll(PageRequest.of(page,size));
	}
	
	public List<Atividade> buscarPorNome(String nome) {
		return repo.findByNomeContainingIgnoreCase(nome);
	}
	public void deleteById(Integer id){
		repo.deleteById(id);
	}
	
	public Atividade save(Atividade atividade) {
		return repo.save(atividade);
	}
	
	
}
