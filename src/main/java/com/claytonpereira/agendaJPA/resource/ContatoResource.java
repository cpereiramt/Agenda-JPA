package com.claytonpereira.agendaJPA.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claytonpereira.agendaJPA.model.Contato;
import com.claytonpereira.agendaJPA.repository.ContatoRepository;

@RestController
@RequestMapping("/agenda")
public class ContatoResource {
	
	  @Autowired
	  ContatoRepository contatoRepository;
	  @GetMapping 
	  public List<Contato> getContatosResource() {
	   return contatoRepository.findAll();
	   }
	 
	  @PostMapping
	  public void insertContatoResource(@RequestBody Contato contato) {
	   contatoRepository.save(contato);
		  
	  }
}
