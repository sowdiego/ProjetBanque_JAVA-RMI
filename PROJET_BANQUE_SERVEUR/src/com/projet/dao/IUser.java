package com.projet.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import com.projet.entities.User;
public interface IUser extends Remote {

	public boolean getConnexion(User u) throws RemoteException;
	//public List<String> listeProfil() throws RemoteException;

}
