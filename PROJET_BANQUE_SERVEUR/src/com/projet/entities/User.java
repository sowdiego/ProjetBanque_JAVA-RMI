package com.projet.entities;

import java.io.Serializable;

public class User implements Serializable{
	private int idU;
	private String loginU;
	private String passwordU;
	private String profil;

	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public String getLoginU() {
		return loginU;
	}
	public void setLoginU(String loginU) {
		this.loginU = loginU;
	}
	public String getPasswordU() {
		return passwordU;
	}
	public void setPasswordU(String passwordU) {
		this.passwordU = passwordU;
	}

	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
}
