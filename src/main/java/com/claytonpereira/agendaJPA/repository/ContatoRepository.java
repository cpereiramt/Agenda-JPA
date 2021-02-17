package com.claytonpereira.agendaJPA.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import com.claytonpereira.agendaJPA.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Integer>  {

	
}
