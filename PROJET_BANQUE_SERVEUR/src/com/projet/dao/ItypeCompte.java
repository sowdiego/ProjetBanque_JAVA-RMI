package com.projet.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import com.projet.entities.TypeCompte;

import javafx.collections.ObservableList;

public interface ItypeCompte extends Remote {
	public List<TypeCompte> listeTC() throws RemoteException;

}
