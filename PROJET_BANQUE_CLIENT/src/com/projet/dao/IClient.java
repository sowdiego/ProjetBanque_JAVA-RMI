package com.projet.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.projet.entities.Client;
import com.projet.entities.Employeur;
import com.projet.entities.TypeClient;

public interface IClient extends Remote  {

	public int add(Client cli) throws RemoteException;
	public int delete(int idClient) throws RemoteException;
	public int update(Client cli) throws RemoteException;
	public List<Client> liste() throws RemoteException;
	public Client getClientByCNI(String cni) throws RemoteException;
	public List<TypeClient> listeTC() throws RemoteException;
	public String numCompte()throws RemoteException;
	public List<Employeur> listeEmp() throws RemoteException;

}
