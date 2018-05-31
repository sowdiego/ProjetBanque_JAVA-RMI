package com.projet.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Compte implements Serializable {
	private int idCompte;
	private String numero;
	private String dateOuverture;
	private int solde;
	private int fraisOuverture;
	private int agio;
	private String remuneration;
	private int delaiBlocage;
	private String etatCompte;
	private String dateEcheance;
	private String dateGele;
	private TypeCompte typeCompte;
	private Charge_Compte chargeCompte;
	private Client client;
	private Agence agence;
	private String cleRIB;


	public Compte() {

	}

	public int getIdCompte() {
		return idCompte;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public int getFraisOuverture() {
		return fraisOuverture;
	}

	public void setFraisOuverture(int fraisOuverture) {
		this.fraisOuverture = fraisOuverture;
	}

	public int getAgio() {
		return agio;
	}

	public void setAgio(int agio) {
		this.agio = agio;
	}

	public String getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(String remuneration) {
		this.remuneration = remuneration;
	}

	public int getDelaiBlocage() {
		return delaiBlocage;
	}

	public void setDelaiBlocage(int delaiBlocage) {
		this.delaiBlocage = delaiBlocage;
	}

	public String getEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(String etatCompte) {
		this.etatCompte = etatCompte;
	}

	public String getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(String dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public String getDateGele() {
		return dateGele;
	}

	public void setDateGele(String dateGele) {
		this.dateGele = dateGele;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

	public Charge_Compte getChargeCompte() {
		return chargeCompte;
	}

	public void setChargeCompte(Charge_Compte chargeCompte) {
		this.chargeCompte = chargeCompte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getCleRIB() {
		return cleRIB;
	}

	public void setCleRIB(String cleRIB) {
		this.cleRIB = cleRIB;
	}


}
