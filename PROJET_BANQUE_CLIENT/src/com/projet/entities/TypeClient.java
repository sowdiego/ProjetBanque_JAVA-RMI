package com.projet.entities;

import java.io.Serializable;

public class TypeClient implements Serializable {

	private int idTypeClient;
	private String nom;
	public TypeClient() {
	}
	public int getIdTypeClient() {
		return idTypeClient;
	}
	public void setIdTypeClient(int idTypeClient) {
		this.idTypeClient = idTypeClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String toString(){
		return this.nom;
	}

}
