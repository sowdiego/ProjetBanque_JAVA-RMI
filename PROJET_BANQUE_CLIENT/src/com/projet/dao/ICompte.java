package com.projet.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.projet.entities.Agence;
import com.projet.entities.Charge_Compte;
import com.projet.entities.Client;
import com.projet.entities.Compte;


public interface ICompte extends Remote {
	public int add(Compte c) throws RemoteException;
	public List<Charge_Compte> listeChC() throws RemoteException;
	public List<Agence> listeAg() throws RemoteException;
	public String cleRIB()throws RemoteException;
	public Client getClientByCNI(String cni) throws RemoteException;
	public Compte getCompteByNum(String numCompte) throws RemoteException;
	public int  updateSolde(int soldeRetrait, String numCompte) throws RemoteException;
	public int  updateSoldeDepot(int soldeRetrait, String numCompte) throws RemoteException;

}
