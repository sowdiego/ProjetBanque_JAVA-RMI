package com.projet.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;


import com.projet.entities.Operation;

public interface Ioperation extends Remote {
	public int add(Operation op) throws RemoteException;
	public Operation getOpereationByDate(String date) throws RemoteException;
}
