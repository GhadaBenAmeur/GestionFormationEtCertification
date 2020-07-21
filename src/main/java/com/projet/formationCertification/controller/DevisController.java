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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@CrossOrigin
public class DevisController {
@Autowired
DevisRepository frm ;
@GetMapping(value="/devis")
public List<Devis> getAll()
{
	return frm.findAll() ; 
}

@RequestMapping(value="/addDevis" , method=RequestMethod.POST)	
public Devis save(@RequestBody Devis d)
{	 
	return frm.save(d) ; 
}


@RequestMapping(value="/enattente/{id}" , method=RequestMethod.GET)
public void enattente(@PathVariable Long id )
{
   Devis d= frm.find(id);
    d.setEtat="en attente"; 
}
@RequestMapping(value="/confirmer/{id}" , method=RequestMethod.GET)
public void confirmer(@PathVariable Long id )
{
   Devis d= frm.find(id);
    d.setEtat="confirmer"; 
}
@RequestMapping(value="/annuler/{id}" , method=RequestMethod.GET)
public void annuler(@PathVariable Long id )
{
   Devis d= frm.find(id);
    d.setEtat="annuler"; 
}

}
