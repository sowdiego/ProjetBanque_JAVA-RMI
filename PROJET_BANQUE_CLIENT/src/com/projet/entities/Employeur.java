package com.projet.entities;

import java.io.Serializable;

public class Employeur  implements Serializable {

	private int idEmployeur;
	private String raison_social;
	private String adress;
	private String nom ;
	private String num_id;
	public Employeur() {
	}
	public int getIdEmployeur() {
		return idEmployeur;
	}
	public void setIdEmployeur(int idEmployeur) {
		this.idEmployeur = idEmployeur;
	}
	public String getRaison_social() {
		return raison_social;
	}
	public void setRaison_social(String raison_social) {
		this.raison_social = raison_social;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNum_id() {
		return num_id;
	}
	public void setNum_id(String num_id) {
		this.num_id = num_id;
	}
	public String toString( ){
		return this.nom;
	}


}
