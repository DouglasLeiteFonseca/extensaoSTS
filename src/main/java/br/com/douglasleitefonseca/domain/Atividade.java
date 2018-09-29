package br.com.douglasleitefonseca.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Atividade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String nome;
	
	public Atividade() {
		
	}
	public  void setNome(String nome) {
		this.nome= nome;
	}
	public Atividade(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}
