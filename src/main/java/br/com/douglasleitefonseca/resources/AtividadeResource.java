package br.com.douglasleitefonseca.resources;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.douglasleitefonseca.domain.Atividade;
import br.com.douglasleitefonseca.services.AtividadeService;

@RestController
@RequestMapping(value="/atividades")
public class AtividadeResource {
	
	@Autowired
	private AtividadeService service;
	
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<?> listar(@RequestParam("page") int page, @RequestParam("size") int size) {
		Page<Atividade> ativ = service.all(page, size);
		return ResponseEntity.ok().body(ativ);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Atividade a1 = service.buscar(id);
		if(a1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(a1);
	}
	
	@RequestMapping(value="like/{nome}", method=RequestMethod.GET)
	public ResponseEntity<?> findByNome(@PathVariable String nome) {
		List<Atividade> atividades = service.buscarPorNome(nome);
		if(atividades.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(atividades);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		try {
			service.deleteById(id);
			return ResponseEntity.ok(id);
		}catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Atividade atividade){
		Atividade ativ = service.save(atividade);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ativ.getId()).toUri();
		return ResponseEntity.created(loc).build();
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar( @Valid @RequestBody Atividade atividade){
		Atividade a1 = service.buscar(atividade.getId());
		if(a1 == null) {
			return ResponseEntity.notFound().build();
		}
		
		service.save(atividade);
		return ResponseEntity.noContent().build();
	}
}
