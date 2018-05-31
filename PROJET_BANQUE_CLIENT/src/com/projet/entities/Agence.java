package com.projet.entities;

import java.io.Serializable;

public class Agence implements Serializable {
	private int idAgence;
	private String nom;
	private String localite;

	public Agence() {

	}

	public int getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public String toString(){
		return this.getIdAgence()+"  "+ getNom()+" "+getLocalite();
	}

}
