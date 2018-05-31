package com.projet.entities;

import java.io.Serializable;

public class Charge_Compte implements Serializable {

	private int idChargeCompte;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;

	public Charge_Compte() {

	}

	public int getIdChargeCompte() {
		return idChargeCompte;
	}

	public void setIdChargeCompte(int idChargeCompte) {
		this.idChargeCompte = idChargeCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	public String toString(){
		return this.getIdChargeCompte()+"  "+ getPrenom()+" "+getNom();
	}


}
