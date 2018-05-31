package com.projet.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Operation implements Serializable {
	private int idOp;
	private String  date;
	private int montant;
	private int taxe;
	private Compte compte;
	private Agence agence;
	private String typeOp;
	public int getIdOp() {
		return idOp;
	}
	public void setIdOp(int idOp) {
		this.idOp = idOp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String  date) {
		this.date = date;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public int getTaxe() {
		return taxe;
	}
	public void setTaxe(int taxe) {
		this.taxe = taxe;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	public String getTypeOp() {
		return typeOp;
	}
	public void setTypeOp(String typeOp) {
		this.typeOp = typeOp;
	}








}
