package com.projet.formationCertification.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.projet.formationCertification.dao.FormationRepository;
import com.projet.formationCertification.entities.Formation;
import com.projet.formationCertification.entities.Proposition;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@CrossOrigin
public class PropositionController {
@Autowired
PropositionRepository frm ;
@GetMapping(value="/proposition")
public List<Proposition> getAll()
{
	return frm.findAll() ; 
}

@RequestMapping(value="/addProposition" , method=RequestMethod.POST)	
public Proposition save(@RequestBody Proposition p)
{	 
	return frm.save(p) ; 
}

@RequestMapping(value="/confirmer/{id}" , method=RequestMethod.GET)
public void confirmer(@PathVariable Long id )
{
   Proposition p= frm.find(id);
    p.setEtat="confirmer"; 
}
@RequestMapping(value="/supprimer/{id}" , method=RequestMethod.GET)
public void supprimer(@PathVariable Long id )
{
   Proposition p= frm.find(id);
    p.setEtat="supprimer"; 
}

}
