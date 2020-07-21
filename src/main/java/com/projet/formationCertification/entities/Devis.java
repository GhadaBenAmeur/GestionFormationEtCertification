package com.projet.formationCertification.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Devis{
   @Id
    @GeneratedValue
    private Long id ; 
	private String formationRecherche ; 
    private Integer nb_participants ;
    private String entreprise;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cin")

    private Demandeur demandeur ;
    
    private String etat;
    
    public Devis() {
		super();
	}

    public String getFormationRecherche() {
        return formationRecherche;
    }
    public void setFormationRecherche(String formationRecherche ) {
        this.formationRecherche = formationRecherche;
    }
    public String getNbParticipants() {
        return nb_participants ;
    }
    public void setNbParticipants(String nb_participants ) {
        this.nb_participants = nb_participants;
    }
    public Demandeur getDemandeur() {
        return demandeur;
    }
    public void setDemandeur(Demandeur demandeur) {
        this.demandeur = demandeur;
    } 
    
    public String getEtat() {
        return etat  ;
    }
    public void setEtat(String etat ) {
        this. etat= etat;
    }
    public String getEntreprise() {
        return entreprise  ;
    }
    public void setEntreprise(String entreprise ) {
        this. entreprise= entreprise;
    }
    
	
	
}
