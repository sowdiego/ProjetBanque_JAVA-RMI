package com.projet.entities;

import java.io.Serializable;

public class Client implements Serializable {


	private String num_piece;
	private String nom;
	private String prenom;
	private String email;
	private String tel;
	private String adresse;
	private  int salaire;
	private String profession;
	private String raison_sociale;
	private String adressEmp;
	private String nomEmp;
	private String numEmp;


	//private Employeur idEmployeur;
	//private TypeClient idTypeClient;


	public String getNum_piece() {
		return num_piece;
	}
	public void setNum_piece(String num_piece) {
		this.num_piece = num_piece;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/*public Employeur getIdEmployeur() {
		return idEmployeur;
	}
	public void setIdEmployeur(Employeur idEmployeur) {
		this.idEmployeur = idEmployeur;
	}
	/*public TypeClient getIdTypeClient() {
		return idTypeClient;
	}
	public void setIdTypeClient(TypeClient idTypeClient) {
		this.idTypeClient = idTypeClient;
	}*/
	public String getRaison_sociale() {
		return raison_sociale;
	}
	public void setRaison_sociale(String raison_sociale) {
		this.raison_sociale = raison_sociale;
	}
	public String getAdressEmp() {
		return adressEmp;
	}
	public void setAdressEmp(String adressEmp) {
		this.adressEmp = adressEmp;
	}
	public String getNomEmp() {
		return nomEmp;
	}
	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}
	public String getNumEmp() {
		return numEmp;
	}
	public void setNumEmp(String numEmp) {
		this.numEmp = numEmp;
	}



}
