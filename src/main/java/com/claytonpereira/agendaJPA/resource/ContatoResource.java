package com.claytonpereira.agendaJPA.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	  
	  @DeleteMapping("/{id}")
	  public void deleteContatoResource(@PathVariable int id) {
		  contatoRepository.deleteById(id);
	  }
	  
	  @PutMapping("/{id}")
	  public void editContatoResource(@PathVariable int id, @RequestBody Contato contato) {
		  Optional<Contato> contatoToUpdate = contatoRepository.findById(id);
		  if (contatoToUpdate.isPresent()) {
			  contatoToUpdate.get().setNome(contato.getNome());
			  contatoToUpdate.get().setEndereco(contato.getEndereco());
			  contatoToUpdate.get().setTelefone(contato.getTelefone());
			  contatoToUpdate.get().setDataNascimento(contato.getDataNascimento());
			  contatoRepository.save(contatoToUpdate.get());
		  }
		  
	  }
}
