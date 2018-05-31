package com.projet.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.projet.entities.TypeClient;

public interface ItypeClient extends Remote {
	public List<TypeClient> listeTC() throws RemoteException;
}
