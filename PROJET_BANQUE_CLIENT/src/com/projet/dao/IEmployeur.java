package com.projet.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import com.projet.entities.Employeur;

public interface IEmployeur extends Remote {
	public int add(Employeur emp) throws RemoteException;

}
