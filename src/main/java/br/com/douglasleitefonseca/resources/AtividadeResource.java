package br.com.douglasleitefonseca.resources;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.douglasleitefonseca.domain.Atividade;
import br.com.douglasleitefonseca.services.AtividadeService;

@RestController
@RequestMapping(value="/atividades")
public class AtividadeResource {
	
	@Autowired
	private AtividadeService service;
	
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.all());
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Atividade a1 = service.buscar(id);
		return ResponseEntity.ok().body(a1);
	}
	
}
