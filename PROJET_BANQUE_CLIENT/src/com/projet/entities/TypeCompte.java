package com.projet.entities;

import java.io.Serializable;



public class TypeCompte implements Serializable {
	private int idCompte;
	private String nomType;


	public TypeCompte() {

	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}



	public String toString(){
		return this.nomType;
	}



}
