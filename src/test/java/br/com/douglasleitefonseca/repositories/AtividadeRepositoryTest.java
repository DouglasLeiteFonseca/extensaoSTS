package br.com.douglasleitefonseca.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.douglasleitefonseca.domain.Atividade;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AtividadeRepositoryTest {
	@Autowired	
	public AtividadeRepository repo;
	
	@Test
	public void verificaQuantidadeAtividadeCadastradas() {
		Page<Atividade> atividades = this.repo.findAll(PageRequest.of(0, 10));
		assertThat(atividades.getTotalElements()).isGreaterThan(1L);
		
	}
	@Test
	public void findByNome() {
		List<Atividade> atividades = this.repo.findByNomeContainingIgnoreCase("POS DE ADS teste cri");
		assertThat(atividades.size()).isEqualTo(1);
	}
	
	
	
}
